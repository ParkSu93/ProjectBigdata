package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Attendance_detailVO;
import vo.StudentListVO;

public class Attendance_detailDAO {
	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.152:1521:xe", "pj", "pj");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	/* 출석체크 이 메소드로만 ㄱㄱ */
	public void attChk(Attendance_detailVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select count(*) from attendance_detail where lec_no = ? and student_id = ? and day = ?");
			pstmt.setInt(1, vo.getLec_no());
			pstmt.setString(2, vo.getStudent_id());
			pstmt.setShort(3, vo.getDay());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					insertAttDetail(vo);
				} else {
					updateAttDetail(vo);
				}
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void insertAttDetail(Attendance_detailVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into attendance_detail(lec_no,student_id,day) values(?,?,?)");
			pstmt.setInt(1, vo.getLec_no());
			pstmt.setString(2, vo.getStudent_id());
			pstmt.setShort(3, vo.getDay());
			pstmt.executeUpdate();
			if (!vo.getAttendance_status().equals("결석")) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(
						"update attendance_detail set attendance_status = ? where lec_no = ? and student_id = ? and day = ?");
				stmt.setString(1, vo.getAttendance_status());
				stmt.setInt(2, vo.getLec_no());
				stmt.setString(3, vo.getStudent_id());
				stmt.setShort(4, vo.getDay());
				stmt.executeUpdate();
				stmt.close();
				PreparedStatement stmt2 = null;
				stmt2 = conn.prepareStatement("execute calc_attendance_rate(?,?)");
				stmt2.setInt(1, vo.getLec_no());
				stmt2.setString(2, vo.getStudent_id());
				stmt2.executeUpdate();
				stmt2.close();
			} else {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("execute calc_attendance_rate(?,?)");
				stmt.setInt(1, vo.getLec_no());
				stmt.setString(2, vo.getStudent_id());
				stmt.executeUpdate();
				stmt.close();
			}
			if (vo.getReport() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(
						"update attendance_detail set report = ? where lec_no = ? and student_id = ? and day = ?");
				stmt.setString(1, vo.getReport());
				stmt.setInt(2, vo.getLec_no());
				stmt.setString(3, vo.getStudent_id());
				stmt.setShort(4, vo.getDay());
				stmt.executeUpdate();
				stmt.close();
			} else {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(
						"update attendance_book set stu_closing_date = (select lec_total_date from lecture where lec_no = ?) where lec_no = ? and student_id = ?");
				stmt.setInt(1, vo.getLec_no());
				stmt.setInt(2, vo.getLec_no());
				stmt.setString(3, vo.getStudent_id());
				stmt.executeUpdate();
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void updateAttDetail(Attendance_detailVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update attendance_detail set attendance_status = ?, report = ? where lec_no = ? and student_id = ? and day = ?");
			pstmt.setString(1, vo.getAttendance_status());
			pstmt.setString(2, vo.getReport());
			pstmt.setInt(3, vo.getLec_no());
			pstmt.setString(4, vo.getStudent_id());
			pstmt.setShort(5, vo.getDay());
			pstmt.executeUpdate();
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement("execute calc_attendance_rate(?,?)");
			stmt.setInt(1, vo.getLec_no());
			stmt.setString(2, vo.getStudent_id());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<StudentListVO> searchAllStudent(int lec_no) {
		Connection conn = null;
		ResultSet rs2 = null;
		ResultSet rs = null;
		ArrayList<StudentListVO> stuList = new ArrayList<StudentListVO>();
		ArrayList<String> person_list = new ArrayList<String>();
		ArrayList<String> rate_list = new ArrayList<String>();

		PreparedStatement stmt = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select student_id from course where lec_no = ?");
			stmt.setInt(1, lec_no);
			rs2 = stmt.executeQuery();
			while (rs2.next()) {
				person_list.add(rs2.getString("student_id"));
			}

			System.out.println(person_list);
			rs2.close();
			stmt.close();
			for(int i=0;i<person_list.size();i++){
				pstmt = conn.prepareStatement(
						"select m.id, m.username, m.birthday, m.email, m.phonenum, m.addr, m.introduce, m.profile, b.stu_start_date, b.stu_closing_date, b.attendance_rate, d.attendance_status from member m, attendance_book b, attendance_detail d, lecture l where m.id=b.student_id and b.student_id=d.student_id and b.lec_no = l.lec_no and d.lec_no = l.lec_no and l.lec_no = ? and m.id = ? order by d.day");
				pstmt.setInt(1, lec_no);
				pstmt.setString(2, person_list.get(i));
				rs = pstmt.executeQuery();

				StudentListVO aInfo = null;
				aInfo = new StudentListVO();
				int chk=0;
				while(rs.next()){
					if(chk==0){
						chk++;
						aInfo.setId(rs.getString("id"));
						aInfo.setUsername(rs.getString("username"));
						aInfo.setBirthday(rs.getString("birthday"));
						aInfo.setEmail(rs.getString("email"));
						aInfo.setPhonenum(rs.getString("phonenum"));
						aInfo.setAddr(rs.getString("addr"));
						aInfo.setIntroduce(rs.getString("introduce"));
						aInfo.setProfile(rs.getString("profile"));
						aInfo.setStu_start_date(rs.getShort("stu_start_date"));
						aInfo.setStu_closing_date(rs.getShort("stu_closing_date"));
					}
					rate_list.add(rs.getString("attendance_status"));
					System.out.println(rs.getString("attendance_status"));
				}
				System.out.println(rate_list);
				for(String str : rate_list)
					aInfo.attendance_status.add(str);
				rate_list.clear();
				System.out.println(aInfo);
				stuList.add(aInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	return stuList;
}
}

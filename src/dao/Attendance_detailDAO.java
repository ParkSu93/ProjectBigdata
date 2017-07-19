package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import vo.Attendance_detailVO;

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
			if (!vo.getAttendance_status().equals("°á¼®")) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(
						"update attendance_detail set attendance_status = ? where lec_no = ? and student_id = ? and day = ?");
				stmt.setString(1, vo.getAttendance_status());
				stmt.setInt(2, vo.getLec_no());
				stmt.setString(3, vo.getStudent_id());
				stmt.setShort(4, vo.getDay());
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
			pstmt.setInt(3,vo.getLec_no());
			pstmt.setString(4,vo.getStudent_id());
			pstmt.setShort(5,vo.getDay());
			pstmt.executeUpdate();
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

}

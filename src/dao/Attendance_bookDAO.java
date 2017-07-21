package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Attendance_bookVO;
import vo.Attendance_detailVO;
import vo.SearchAttBookVO;

public class Attendance_bookDAO {
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

	public void insertAttBook(Attendance_bookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into attendance_book(lec_no,student_id) values(?,?)");
			pstmt.setInt(1, vo.getLec_no());
			pstmt.setString(2, vo.getStudent_id());
			pstmt.executeUpdate();
			Attendance_detailVO attd = new Attendance_detailVO();
			attd.setLec_no(vo.getLec_no());
			attd.setStudent_id(vo.getStudent_id());
			attd.setDay((short)1);
			Attendance_detailDAO attdDAO = new Attendance_detailDAO();
			attdDAO.insertAttDetail(attd);
			if (vo.getStu_start_date() != 1) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(
						"update attendance_book set stu_start_date = ? where lec_no = ? and student_id = ?");
				stmt.setShort(1, vo.getStu_start_date());
				stmt.setInt(2, vo.getLec_no());
				stmt.setString(3, vo.getStudent_id());
				stmt.executeUpdate();
				stmt.close();
			} 
			if (vo.getStu_closing_date() != 0) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement(
						"update attendance_book set stu_closing_date = ? where lec_no = ? and student_id = ?");
				stmt.setShort(1, vo.getStu_closing_date());
				stmt.setInt(2, vo.getLec_no());
				stmt.setString(3, vo.getStudent_id());
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

	public SearchAttBookVO searchAttBook(int lec_no, String student_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		SearchAttBookVO atdcInfo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select a.lec_no, l.lec_name, a.attendance_rate, a.stu_start_date, a.stu_closing_date from attendance_book a, lecture l where a.lec_no = l.lec_no and a.lec_no= ? and a.student_id = ?");
			pstmt.setInt(1, lec_no);
			pstmt.setString(2, student_id);
			ResultSet rs = pstmt.executeQuery();
			atdcInfo = new SearchAttBookVO();
			if (rs.next()) {
				atdcInfo.setLec_no(rs.getInt(1));
				atdcInfo.setLec_name(rs.getString(2));
				atdcInfo.setAttendance_rate(rs.getByte(3));
				atdcInfo.setStu_start_date(rs.getShort(4));
				atdcInfo.setStu_closing_date(rs.getShort(5));
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

		return atdcInfo;
	}

	public void updateAttBook(Attendance_bookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update attendance_book set stu_start_date = ?, stu_closing_date = ? where lec_no = ? and student_id = ?");
			pstmt.setShort(1, vo.getStu_start_date());
			pstmt.setShort(2, vo.getStu_closing_date());
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

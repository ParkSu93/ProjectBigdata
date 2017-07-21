package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Attendance_bookVO;
import vo.CourseVO;

public class CourseDAO {
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

	public void insertCourse(CourseVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into course values(?,?)");
			pstmt.setInt(1, vo.getLec_no());
			pstmt.setString(2, vo.getStudent_id());
			pstmt.executeUpdate();
			Attendance_bookVO attb = new Attendance_bookVO();
			attb.setLec_no(vo.getLec_no());
			attb.setStudent_id(vo.getStudent_id());
			Attendance_bookDAO attbDAO = new Attendance_bookDAO();
			attbDAO.insertAttBook(attb);
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement("update lecture set enroll_num = calc_enroll_num(?) where lec_no = ?");
			stmt.setInt(1, vo.getLec_no());
			stmt.setInt(2, vo.getLec_no());
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

	public ArrayList<CourseVO> searchCourse(String student_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<CourseVO> list = new ArrayList<CourseVO>();
		ResultSet rs = null;

		CourseVO course = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from course where student_id = ?");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				course = new CourseVO();
				course.setLec_no(rs.getInt(1));
				course.setStudent_id(rs.getString(2));
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	public void deleteCourse(int lec_no, String student_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from course where lec_no = ? and student_id = ?");
			pstmt.setInt(1, lec_no);
			pstmt.setString(2, student_id);
			pstmt.executeUpdate();
			PreparedStatement stmt = null;
			stmt = conn.prepareStatement("update lecture set enroll_num = calc_enroll_num(?) where lec_no = ?");
			stmt.setInt(1, lec_no);
			stmt.setInt(2, lec_no);
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

}

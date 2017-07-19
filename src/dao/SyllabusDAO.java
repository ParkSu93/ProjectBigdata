package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.SyllabusVO;

public class SyllabusDAO {
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

	public void insertSyllabus(SyllabusVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into Syllabus(lec_no) values(?)");
			pstmt.setInt(1, vo.getLec_no());
			pstmt.executeUpdate();

			if (vo.getLec_outline() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update syllabus set lec_outline = ? where lec_no = ?");
				stmt.setString(1, vo.getLec_outline());
				stmt.setInt(2, vo.getLec_no());
				stmt.executeUpdate();
				stmt.close();
			}
			if (vo.getLec_goal() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update syllabus set lec_goal = ? where lec_no = ?");
				stmt.setString(1, vo.getLec_goal());
				stmt.setInt(2, vo.getLec_no());
				stmt.executeUpdate();
				stmt.close();
			}
			if (vo.getLec_time() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update syllabus set lec_time = ? where lec_no = ?");
				stmt.setString(1, vo.getLec_time());
				stmt.setInt(2, vo.getLec_no());
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

	public SyllabusVO searchSyllabus(int lec_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		SyllabusVO sInfo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from syllabus where lec_no=?");
			pstmt.setInt(1, lec_no);
			ResultSet rs = pstmt.executeQuery();
			sInfo = new SyllabusVO();
			if (rs.next()) {
				sInfo.setLec_no(rs.getInt("lec_no"));
				sInfo.setLec_outline(rs.getString("lec_outline"));
				sInfo.setLec_goal(rs.getString("lec_goal"));
				sInfo.setLec_time(rs.getString("lec_time"));
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

		return sInfo;
	}

	public void updateSyllabus(SyllabusVO vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update lecture set lec_outline=?,lec_goal=?,lec_time=? where lec_no = ?");
			pstmt.setString(1, vo.getLec_outline());
			pstmt.setString(2, vo.getLec_goal());
			pstmt.setString(3, vo.getLec_time());
			pstmt.setInt(4, vo.getLec_no());
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

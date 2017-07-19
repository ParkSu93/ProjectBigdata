package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.LectureVO;

public class LectureDAO {
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

	public void insertLecture(LectureVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"insert into lecture(lec_no,teacher_id,lec_name,lec_password,lec_start_date) values(lec_no_seq.nextval,?,?,?,?)");
			pstmt.setString(1, vo.getTeacher_id());
			pstmt.setString(2, vo.getLec_name());
			pstmt.setString(3, vo.getLec_password());
			pstmt.setString(4, vo.getLec_start_date());
			pstmt.executeUpdate();

			if (vo.getCompletion_rate() != 70) {
				PreparedStatement stmt = null;
				stmt = conn
						.prepareStatement("update lecture set completion_rate = ? where lec_no = lec_no_seq.currval");
				stmt.setByte(1, vo.getCompletion_rate());
				stmt.executeUpdate();
				stmt.close();
			}
			if (vo.getLec_closing_date() != null) {
				PreparedStatement stmt = null;
				stmt = conn
						.prepareStatement("update lecture set lec_closing_date = ? where lec_no = lec_no_seq.currval");
				stmt.setString(1, vo.getLec_closing_date());
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

	public LectureVO searchLecture(int lec_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		LectureVO lInfo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from lecture where lec_no=?");
			pstmt.setInt(1, lec_no);
			ResultSet rs = pstmt.executeQuery();
			lInfo = new LectureVO();
			if (rs.next()) {
				lInfo.setLec_no(rs.getInt("lec_no"));
				lInfo.setTeacher_id(rs.getString("teacher_id"));
				lInfo.setLec_name(rs.getString("lec_name"));
				lInfo.setLec_password(rs.getString("lec_password"));
				lInfo.setEnroll_num(rs.getShort("enroll_num"));
				lInfo.setCompletion_rate(rs.getByte("completion_rate"));
				lInfo.setLec_start_date(rs.getString("lec_start_date"));
				lInfo.setLec_closing_date(rs.getString("lec_closing_date"));
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

		return lInfo;
	}

	public void deleteLecture(int lec_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from lecture where lec_no = ?");
			pstmt.setInt(1, lec_no);
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

	public void updateLecture(LectureVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update lecture set lec_name=?,lec_password=?,completion_rate=?,lec_start_date=?,lec_closing_date=? where lec_no = ?");
			pstmt.setString(1, vo.getLec_name());
			pstmt.setString(2, vo.getLec_password());
			pstmt.setByte(3, vo.getCompletion_rate());
			pstmt.setString(4, vo.getLec_start_date());
			pstmt.setString(5, vo.getLec_closing_date());
			pstmt.setInt(6, vo.getLec_no());
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

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.MemberVO;

public class MemberDAO {
	
	static MemberDAO dao = new MemberDAO();

	public MemberDAO getInstance() {
		return dao;
	}
	
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

	public void insertMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("dao:  "+ vo.toString());
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"insert into member(id,password,username,birthday,email,phonenum) values(?,?,?,?,?,?)");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getBirthday());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhonenum());
			pstmt.executeUpdate();

			if (vo.getAddr() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update member set addr = ? where id = ?");
				stmt.setString(1, vo.getAddr());
				stmt.setString(2, vo.getId());
				stmt.executeUpdate();
			}
			if (vo.getIntroduce() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update member set introduce = ? where id = ?");
				stmt.setString(1, vo.getIntroduce());
				stmt.setString(2, vo.getId());
				stmt.executeUpdate();
			}
			if (vo.getTeacher_flag() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update member set teacher_flag = ? where id = ?");
				stmt.setString(1, vo.getTeacher_flag());
				stmt.setString(2, vo.getId());
				stmt.executeUpdate();
			}
			if (vo.getProfile() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update member set profile = ? where id = ?");
				stmt.setString(1, vo.getProfile().getOriginalFilename());
				stmt.setString(2, vo.getId());
				stmt.executeUpdate();
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

	public MemberVO searchMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberVO mInfo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			mInfo = new MemberVO();
			if (rs.next()) {
				mInfo.setId(rs.getString("id"));
				mInfo.setPassword(rs.getString("password"));
				mInfo.setUsername(rs.getString("username"));
				mInfo.setBirthday(rs.getString("birthday"));
				mInfo.setEmail(rs.getString("email"));
				mInfo.setPhonenum(rs.getString("phonenum"));
				mInfo.setAddr(rs.getString("addr"));
				mInfo.setIntroduce(rs.getString("introduce"));
				mInfo.setTeacher_flag(rs.getString("teacher_flag"));
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

		return mInfo;
	}

	public void deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from member where id = ?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update member set password=?,email=?,phonenum=?,addr=?,introduce=? where id = ?");
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhonenum());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getIntroduce());
			pstmt.setString(6, vo.getId());
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

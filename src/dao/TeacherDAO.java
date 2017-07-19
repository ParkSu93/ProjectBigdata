package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.MemberVO;
import vo.TeacherVO;

public class TeacherDAO extends MemberDAO {
	
	static TeacherDAO dao = new TeacherDAO();

	public TeacherDAO getInstance() {
		return dao;
	}
	public void insertTeacher(TeacherVO vo) {
		insertMember((MemberVO) vo);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into teacher(teacher_id) values(?)");
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			if (vo.getEdu_background() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update teacher set edu_background = ? where teacher_id = ?");
				stmt.setString(1, vo.getEdu_background());
				stmt.setString(2, vo.getId());
				stmt.executeUpdate();
			}
			if (vo.getCareer() != null) {
				PreparedStatement stmt = null;
				stmt = conn.prepareStatement("update teacher set career = ? where teacher_id = ?");
				stmt.setString(1, vo.getCareer());
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

	public TeacherVO searchTeacher(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		TeacherVO tInfo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select t.teacher_id,m.password,m.username,m.birthday,m.email,m.phonenum,m.addr,m.introduce,m.teacher_flag,t.edu_background,t.career from teacher t, member m where t.teacher_id = m.id and t.teacher_id = ?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			tInfo = new TeacherVO();
			if (rs.next()) {
				tInfo.setId(rs.getString("teacher_id"));
				tInfo.setPassword(rs.getString("password"));
				tInfo.setUsername(rs.getString("username"));
				tInfo.setBirthday(rs.getString("birthday"));
				tInfo.setEmail(rs.getString("email"));
				tInfo.setPhonenum(rs.getString("phonenum"));
				tInfo.setAddr(rs.getString("addr"));
				tInfo.setIntroduce(rs.getString("introduce"));
				tInfo.setTeacher_flag(rs.getString("teacher_flag"));
				tInfo.setEdu_background(rs.getString("edu_background"));
				tInfo.setCareer(rs.getString("career"));
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

		return tInfo;
	}
	
	public void updateTeacher(TeacherVO vo){
		updateMember((MemberVO)vo);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update teacher edu_background=?,career=? where teacher_id = ?");
			pstmt.setString(1, vo.getEdu_background());
			pstmt.setString(2, vo.getCareer());
			pstmt.setString(3, vo.getId());
		}catch (Exception e) {
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

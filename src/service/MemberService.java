package service;

import org.springframework.stereotype.Service;

import dao.MemberDAO;
import dao.TeacherDAO;
import vo.MemberVO;
import vo.TeacherVO;

/*
 * 회원 Service
 */
@Service
public class MemberService {

	TeacherDAO dao = new TeacherDAO().getInstance();

	/*
	 * 회원가입
	 */
	public String joinMember(TeacherVO mem) {
		if (mem.getTeacher_flag().equals("Y")) {
			dao.insertTeacher(mem);
		} else {
			dao.insertMember((MemberVO) mem);
		}
		return "가입완료";
	}

	/*
	 * 로그인
	 */
	public Object loginMember(String id, String password) {
		MemberVO vo = null;
		String result = null;
		try {
			vo = dao.searchMember(id);
			if (password.equals(vo.getPassword())) {
				result = "로그인 성공";
			} else {
				result = "비밀번호가 틀렸습니다";
				return result;
			}
		} catch (NullPointerException e) {
			result = "해당 ID 가 존재하지 않습니다.";
			return result;
		}

		return vo;
	}

	public Object getMemberInfo(String id, String flag) {
		Object obj = null;
		if (flag.equals("Y") || flag.equals("y")) {
			obj = dao.searchTeacher(id);
		} else {
			obj = dao.searchMember(id);
		}
		return obj;
	}

	/**
	 * 회원정보 업데이트
	 * 
	 * @param vo
	 */
	public void updateMemberInfo(Object vo) {
		if (vo instanceof MemberVO) {
			dao.updateMember((MemberVO) vo);
		} else {
			dao.updateTeacher((TeacherVO) vo);
		}

	}
}

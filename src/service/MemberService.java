package service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import vo.MemberVO;

/*
 * 회원 Service
 */
@Service
public class MemberService {

	MemberDAO dao = new MemberDAO().getInstance();

	/*
	 * 회원가입
	 */
	public String joinMember(MemberVO mem) {
		dao.insertMember(mem);
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
			} else{
				result = "비밀번호가 틀렸습니다";
				return result;
			}
		} catch (NullPointerException e) {
			result = "해당 ID 가 존재하지 않습니다.";
			return result;
		}

		return vo;
	}
}

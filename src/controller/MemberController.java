package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import sun.security.jca.GetInstance.Instance;
import validate.MemberValidator;
import vo.MemberVO;

@Controller
public class MemberController {

	/**
	 * 첫 로그인 페이지를 호출한다.
	 * 
	 * @return login.jsp(로그인 페이지)
	 */
	@RequestMapping(value = "view/login.do", method = RequestMethod.GET)
	public String getMemberLoginPage() {
		return "index";
	}

	/**
	 * 로그인 수행
	 * 
	 * @param mem
	 *            회원 id, password
	 * @return 회원 정보, 반환할 페이지를 담은 ModelAndView
	 */
	@RequestMapping(value = "view/login.do", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("mem") MemberVO mem, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		Object obj = new MemberService().loginMember(mem.getId(), mem.getPassword());
		if (obj instanceof MemberVO) {
			MemberVO vo = (MemberVO) obj;
			String flag = vo.getTeacher_flag();

			// 세션 추가
			HttpSession session = null;
			session = req.getSession();
			session.setAttribute("mem", vo);

			if (flag.equals("Y"))
				mav.setViewName("teacherMain");
			else
				mav.setViewName("studentMain");
		} else {
			String result = (String) obj;
			mav.addObject("result", result);
			mav.setViewName("index");
		}
		return mav;
	}

	/**
	 * 회원가입 페이지를 호출한다.
	 * 
	 * @return join.jsp(로그인 페이지)
	 */
	@RequestMapping(value = "view/join.do", method = RequestMethod.GET)
	public String getMemberJoinPage() {
		return "index";
	}

	@RequestMapping(value = "view/join.do", method = RequestMethod.POST)
	public String doJoin(@ModelAttribute("mem") MemberVO mem, BindingResult valiResult) {
		// 유효성 체크
		new MemberValidator().validate(mem, valiResult); // 유효성 체크할 객체, 오류발생시
															// 등록할 Map객체
		// ** result가 비어있으면 내용이 등록되지 않았으므로 오류가 없다!
		if (valiResult.hasErrors())// 에러를 가지고 있는지 확인. = (isEmpty() 와 반대)
			return "index";

		String str = new MemberService().joinMember(mem);

		/*
		 * if (str.equals("가입완료")) return "loin"; else return "index";
		 */
		return "index";
	}
}
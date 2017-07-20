package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.LectureService;
import service.MemberService;
import vo.MemberVO;
import vo.MyLectureVO;
import vo.TeacherVO;

@Controller
public class MemberController {

	static MemberService service = new MemberService();

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
		ModelAndView mav2 = new ModelAndView();
		Object obj = service.loginMember(mem.getId(), mem.getPassword());
		if (obj instanceof MemberVO) {
			MemberVO vo = (MemberVO) obj;
			String flag = vo.getTeacher_flag();

			// 세션 추가
			HttpSession session = null;
			session = req.getSession();
			session.setAttribute("mem", vo);

			Object obj2 = service.getMemberInfo(vo.getId(), vo.getTeacher_flag());
<<<<<<< HEAD
			if (flag.equals("Y")){
				
				ArrayList<MyLectureVO> lecturelist = new ArrayList<>();
				String id = mem.id;
				
				LectureService service = new LectureService();
				lecturelist = service.lectureList(id);
				
				TeacherVO mem2 =  (TeacherVO)obj2;
				System.out.println("제발보여줘"+lecturelist.toString());
				mav.addObject("list", lecturelist);;
				mav.addObject("memberInfo", mem2);			
				mav.setViewName("teacherMain");
				
				System.out.println(mem.toString());
			}else{
				MemberVO mem2 = (MemberVO)obj2;
=======
			if (flag.equals("Y") || flag.equals("y")) {
				TeacherVO mem2 = (TeacherVO) obj2;
				mav.addObject("memberInfo", mem2);
				mav.setViewName("teacherMain");
				System.out.println("로그인 강사" + mem.toString());
			} else {
				MemberVO mem2 = (MemberVO) obj2;
>>>>>>> 620af6a6c317e55cf5401b7b408c2f20499be328
				mav.addObject("memberInfo", mem2);
				mav.setViewName("studentMain");
				System.out.println("로그인 학생" + mem.toString());
			}
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

	/**
	 * 회원가입 수행
	 * 
	 * @param mem
	 * @param valiResult
	 * @return
	 */
	@RequestMapping(value = "view/join.do", method = RequestMethod.POST)
	public String doJoin(@ModelAttribute("mem") TeacherVO mem, BindingResult valiResult) {
		// 유효성 체크
		/*
		 * new MemberValidator().validate(mem, valiResult); // 유효성 체크할 객체, 오류발생시
		 * // 등록할 Map객체 // ** result가 비어있으면 내용이 등록되지 않았으므로 오류가 없다! if
		 * (valiResult.hasErrors())// 에러를 가지고 있는지 확인. = (isEmpty() 와 반대) return
		 * "index";
		 */

		if (mem == null)
			System.out.println("아무것도 없어염");

		System.out.println("controller:  " + mem.getTeacher_flag());

		String str = service.joinMember(mem);

		// if (str.equals("가입완료")) return "loin"; else return "index";

		return "index";
	}

	@RequestMapping(value = "view/profile.do")
	public ModelAndView getProfilePage(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		HttpSession session = null;
		session = req.getSession();
		MemberVO vo =null;
		if (session != null) {
			 vo = (MemberVO) session.getAttribute("mem");
		}else{
			mav.setViewName("login");
		}
		Object obj = service.getMemberInfo(vo.getId(), vo.getTeacher_flag());
		if (obj instanceof TeacherVO) {
			TeacherVO mem = (TeacherVO) obj;
			mav.addObject("memberInfo", mem);
			mav.setViewName("teacherProfile");
			System.out.println("프로필 강사" + mem.toString());
		} else {
			MemberVO mem = (MemberVO) obj;
			mav.addObject("memberInfo", mem);
			mav.setViewName("studentProfile");
			System.out.println("프로필 학생" + mem.toString());
		}

		System.out.println();
		return mav;
	}

}
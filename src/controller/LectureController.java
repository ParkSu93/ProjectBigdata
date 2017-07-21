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
import vo.Attendance_bookVO;
import vo.Attendance_detailVO;
import vo.CourseVO;
import vo.LectureVO;
import vo.MemberVO;
import vo.MyLectureVO;
import vo.SyllabusVO;
import vo.TeacherVO;

@Controller
public class LectureController {
	
	static LectureService service = new LectureService();

	//령현 - 강의 추가
	@RequestMapping(value = "view/regLecture.do", method = RequestMethod.POST)
	public String insertLecture(@ModelAttribute("lec") MyLectureVO lec, HttpServletRequest req) {
		HttpSession se = req.getSession();
		String teacher_id = ((MemberVO)se.getAttribute("mem")).getId();
		lec.setTeacher_id(teacher_id);
		
		service.insertLecture(lec);
		
		return "teacherMain";
	}
	
	// 령현 - 강사가 강의 삭제
	@RequestMapping(value = "view/deleteLecture.do", method = RequestMethod.POST)
	public ModelAndView deleteLecture(@ModelAttribute("lec") LectureVO lec, HttpServletRequest req) {
		System.out.println("이름 넘어오니: "+lec);
		service.deleteLecture(lec.getLec_name());
		
		ModelAndView mav = new ModelAndView();
		HttpSession se = req.getSession();
		
		ArrayList<MyLectureVO> lecturelist = new ArrayList<>();
		lecturelist = service.lectureList((String)se.getAttribute("id"));
		
		mav.addObject("list", lecturelist);;
		mav.setViewName("teacherMain");
		
		return mav;
	}
}

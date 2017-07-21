package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String deleteLecture(@ModelAttribute("lec") LectureVO lec, BindingResult result) {
		System.out.println(lec);

		service.deleteLecture(lec.getLec_name());
		
		
		return "teacherMain";
	}
}

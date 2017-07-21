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
	
<<<<<<< HEAD
	// 령현 - 강사가 강의 삭제
	@RequestMapping(value = "view/deleteLecture.do", method = RequestMethod.POST)
	public String deleteLecture(@ModelAttribute("lec") LectureVO lec, BindingResult result) {
=======
	@RequestMapping(value = "syllabus3.do", method = RequestMethod.POST)
	public String updateSyllabus(@ModelAttribute("syl3") SyllabusVO syl3, BindingResult result) {
		System.out.println(syl3);

		service.updateSyllabus(syl3);
		
		
		return "syllabusOutput";
	}
	@RequestMapping(value = "syllabus4.do", method = RequestMethod.POST)
	public String myLectureList(@ModelAttribute("syl4") TeacherVO syl4, BindingResult result) {
		System.out.println(syl4);

		service.lectureList(syl4.getId());
		
		
		return "syllabusOutput";
	}
	@RequestMapping(value = "lecPlus.do", method = RequestMethod.GET)
	public String lecPlus() {

		return "lectureInput";
	}
	
	@RequestMapping(value = "lecPlus2.do", method = RequestMethod.POST)
	public String searchLecture(@ModelAttribute("lec2") LectureVO lec2, BindingResult result) {
		System.out.println(lec2);

		service.searchLecture(lec2.getLec_no());
		
		
		return "lectureOutput";
	}
	
	@RequestMapping(value = "lecPlus3.do", method = RequestMethod.POST)
	public String deleteLecture(@ModelAttribute("lec3") LectureVO lec3, BindingResult result) {
		System.out.println(lec3);

		//service.deleteLecture(lec3.getLec_no());
		
		
		return "lectureOutput";
	}
	
	@RequestMapping(value = "lecPlus4.do", method = RequestMethod.POST)
	public String lecPlus(@ModelAttribute("lec") LectureVO lec, BindingResult result) {
>>>>>>> 0ccf4909f8cb1fe34635fdd3353baa4eec76c6c8
		System.out.println(lec);

		service.deleteLecture(lec.getLec_name());
		
		
		return "teacherMain";
	}
}

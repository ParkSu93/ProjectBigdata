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



	@RequestMapping(value = "syllabus.do", method = RequestMethod.GET)
	public String syllabus() {

		return "syllabusInput";
	}

	@RequestMapping(value = "syllabus.do", method = RequestMethod.POST)
	public String insertSyllabus(@ModelAttribute("syl") SyllabusVO syl, BindingResult result) {
		System.out.println(syl);

		service.insertSyllabus(syl);
		
		
		return "syllabusOutput";
	}
	@RequestMapping(value = "syllabus2.do", method = RequestMethod.POST)
	public String searchSyllabus(@ModelAttribute("syl2") SyllabusVO syl2, BindingResult result) {
		System.out.println(syl2);

		service.searchSyllabus(syl2.getLec_no());
		
		
		return "syllabusOutput";
	}
	
	
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

		service.deleteLecture(lec3.getLec_no());
		
		
		return "lectureOutput";
	}
	@RequestMapping(value = "lecPlus4.do", method = RequestMethod.POST)
	public String lecPlus(@ModelAttribute("lec") LectureVO lec, BindingResult result) {
		System.out.println(lec);

		service.updateLecture(lec);
		
		
		return "lectureOutput";
	}
	@RequestMapping(value = "course.do", method = RequestMethod.GET)
	public String course2() {

		return "courseInput";
	}

	@RequestMapping(value = "course.do", method = RequestMethod.POST)
	public String insertCourse(@ModelAttribute("cou") CourseVO cou, BindingResult result) {
		System.out.println(cou);

		service.insertCourse(cou);
		
		
		return "courseOutput";
	}
	@RequestMapping(value = "course2.do", method = RequestMethod.POST)
	public String searchCourse(@ModelAttribute("cou2") CourseVO cou2, BindingResult result) {
		System.out.println(cou2);

		service.searchCourse(cou2.getStudent_id());
		
		
		return "courseOutput";
	}
	@RequestMapping(value = "course3.do", method = RequestMethod.POST)
	public String deleteCourse(@ModelAttribute("cou3") CourseVO cou3, BindingResult result) {
		System.out.println(cou3);

		service.deleteCourse(cou3.getLec_no(), cou3.getStudent_id());
		
		
		return "courseOutput";
	}
	@RequestMapping(value = "attendance_detail.do", method = RequestMethod.GET)
	public String course() {

		return "attendance_detailInput";
	}

	@RequestMapping(value = "attendance_detail.do", method = RequestMethod.POST)
	public String insertAttDetail(@ModelAttribute("ade") Attendance_detailVO ade, BindingResult result) {
		System.out.println(ade);

		service.insertAttDetail(ade);
		
		
		return "attendance_detailOutput";
	}
	
	@RequestMapping(value = "attendance_detail2.do", method = RequestMethod.POST)
	public String updateAttDetail(@ModelAttribute("ade2") Attendance_detailVO ade2, BindingResult result) {
		System.out.println(ade2);

		service.updateAttDetail(ade2);
		
		
		return "attendance_detailOutput";
	}
	@RequestMapping(value = "attendance_book.do", method = RequestMethod.GET)
	public String attendance_book() {

		return "attendance_bookInput";
	}

}

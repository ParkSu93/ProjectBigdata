package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.LectureService;
import vo.Attendance_detailVO;
import vo.CourseVO;
import vo.LectureVO;
import vo.SyllabusVO;
import vo.TeacherVO;

@Controller
public class LectureController {
	@RequestMapping(value = "syllabus.do", method = RequestMethod.GET)
	public String syllabus() {

		return "syllabusInput";
	}

	@RequestMapping(value = "syllabus.do", method = RequestMethod.POST)
	public String insertSyllabus(@ModelAttribute("syl") SyllabusVO syl, BindingResult result) {
		System.out.println(syl);

		new LectureService().insertSyllabus(syl);
		
		
		return "syllabusOutput";
	}
	@RequestMapping(value = "syllabus2.do", method = RequestMethod.POST)
	public String searchSyllabus(@ModelAttribute("syl2") SyllabusVO syl2, BindingResult result) {
		System.out.println(syl2);

		new LectureService().searchSyllabus(syl2.getLec_no());
		
		
		return "syllabusOutput";
	}
	
	
	@RequestMapping(value = "syllabus3.do", method = RequestMethod.POST)
	public String updateSyllabus(@ModelAttribute("syl3") SyllabusVO syl3, BindingResult result) {
		System.out.println(syl3);

		new LectureService().updateSyllabus(syl3);
		
		
		return "syllabusOutput";
	}
	@RequestMapping(value = "syllabus4.do", method = RequestMethod.POST)
	public String myLectureList(@ModelAttribute("syl4") TeacherVO syl4, BindingResult result) {
		System.out.println(syl4);

		new LectureService().lectureList(syl4.getId());
		
		
		return "syllabusOutput";
	}
	@RequestMapping(value = "lecPlus.do", method = RequestMethod.GET)
	public String lecPlus() {

		return "lectureInput";
	}

	@RequestMapping(value = "lecPlus.do", method = RequestMethod.POST)
	public String insertLecture(@ModelAttribute("lec") LectureVO lec, BindingResult result) {
		System.out.println(lec);

		new LectureService().insertLecture(lec);
		
		
		return "lectureOutput";
	}
	@RequestMapping(value = "lecPlus2.do", method = RequestMethod.POST)
	public String searchLecture(@ModelAttribute("lec2") LectureVO lec2, BindingResult result) {
		System.out.println(lec2);

		new LectureService().searchLecture(lec2.getLec_no());
		
		
		return "lectureOutput";
	}
	@RequestMapping(value = "lecPlus3.do", method = RequestMethod.POST)
	public String deleteLecture(@ModelAttribute("lec3") LectureVO lec3, BindingResult result) {
		System.out.println(lec3);

		new LectureService().deleteLecture(lec3.getLec_no());
		
		
		return "lectureOutput";
	}
	@RequestMapping(value = "lecPlus4.do", method = RequestMethod.POST)
	public String lecPlus(@ModelAttribute("lec") LectureVO lec, BindingResult result) {
		System.out.println(lec);

		new LectureService().updateLecture(lec);
		
		
		return "lectureOutput";
	}
	@RequestMapping(value = "course.do", method = RequestMethod.GET)
	public String course2() {

		return "courseInput";
	}

	@RequestMapping(value = "course.do", method = RequestMethod.POST)
	public String insertCourse(@ModelAttribute("cou") CourseVO cou, BindingResult result) {
		System.out.println(cou);

		new LectureService().insertCourse(cou);
		
		
		return "courseOutput";
	}
	@RequestMapping(value = "course2.do", method = RequestMethod.POST)
	public String searchCourse(@ModelAttribute("cou2") CourseVO cou2, BindingResult result) {
		System.out.println(cou2);

		new LectureService().searchCourse(cou2.getStudent_id());
		
		
		return "courseOutput";
	}
	@RequestMapping(value = "course3.do", method = RequestMethod.POST)
	public String deleteCourse(@ModelAttribute("cou3") CourseVO cou3, BindingResult result) {
		System.out.println(cou3);

		new LectureService().deleteCourse(cou3.getLec_no(), cou3.getStudent_id());
		
		
		return "courseOutput";
	}
	@RequestMapping(value = "attendance_detail.do", method = RequestMethod.GET)
	public String course() {

		return "attendance_detailInput";
	}

	@RequestMapping(value = "attendance_detail.do", method = RequestMethod.POST)
	public String insertAttDetail(@ModelAttribute("ade") Attendance_detailVO ade, BindingResult result) {
		System.out.println(ade);

		new LectureService().insertAttDetail(ade);
		
		
		return "attendance_detailOutput";
	}
	
	@RequestMapping(value = "attendance_detail2.do", method = RequestMethod.POST)
	public String updateAttDetail(@ModelAttribute("ade2") Attendance_detailVO ade2, BindingResult result) {
		System.out.println(ade2);

		new LectureService().updateAttDetail(ade2);
		
		
		return "attendance_detailOutput";
	}
}

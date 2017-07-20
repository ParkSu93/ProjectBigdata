package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.AttendanceService;
import vo.Attendance_detailVO;
import vo.LectureVO;
import vo.StudentListVO;

@Controller
public class AttendanceController {
	
	static AttendanceService service = new AttendanceService();

	// 강사 입장 - 해당 강의에 참여하는 학생 출결 정보 전체 가져오기
	@RequestMapping("myAttedance.do")
	public ModelAndView getAttendStudentList(@ModelAttribute("lec")LectureVO lec ,HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		HttpSession se = req.getSession();
		
		StudentListVO list = service.getAttendStudentList(lec.getLec_no());
		mav.addObject("list",list);
		mav.setViewName("attendenceList");
		return mav;
	}

}

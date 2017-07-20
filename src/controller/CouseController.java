package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CouserService;
import vo.CourseVO;
import vo.MemberVO;

@Controller
public class CouseController {
	static CouserService service = new CouserService();
	
	@RequestMapping(value = "view/addMyLecture.do",method = RequestMethod.POST)
	public String addMyLecture(CourseVO vo,HttpServletRequest req){ //학생 id, 강의 번호.
		
		service.insertCourse(vo);
		return "studentMain";
	}
}

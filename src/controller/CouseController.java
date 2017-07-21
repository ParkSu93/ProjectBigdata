package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.CouserService;
import service.LectureService;
import vo.CourseVO;
import vo.LectureVO;
import vo.MemberVO;

@Controller
public class CouseController {
	static CouserService service = new CouserService();
	static LectureService l_service = new LectureService();
	
	@RequestMapping(value = "view/addMyLecture.do",method = RequestMethod.POST)
	public ModelAndView addMyLecture(CourseVO vo,HttpServletRequest req){ //학생 id, 강의 번호.
		
		ModelAndView mav = new ModelAndView();
		HttpSession se = req.getSession();
		System.out.println("course컨트롤러:  " + vo);
		service.insertCourse(vo);

		ArrayList<LectureVO> my_list = l_service.Alllecturelist((String)se.getAttribute("id"));
		ArrayList<LectureVO> total_list = l_service.totallecturelist((String)se.getAttribute("id"));
<<<<<<< HEAD
=======
		
		System.out.println(my_list);
		System.out.println(total_list);
		
>>>>>>> 0ccf4909f8cb1fe34635fdd3353baa4eec76c6c8
		mav.addObject("my_list", my_list);
		mav.addObject("total_list",total_list);
		mav.setViewName("studentMain");
		
		return mav;
	}
}

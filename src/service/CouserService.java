package service;

import org.springframework.stereotype.Service;

import dao.CourseDAO;
import vo.CourseVO;

@Service
public class CouserService {
	static CourseDAO corseDao = new CourseDAO();

	public void insertCourse(CourseVO vo){
		corseDao.insertCourse(vo);
	}
}

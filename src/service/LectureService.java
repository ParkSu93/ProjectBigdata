package service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import dao.Attendance_detailDAO;
import dao.CourseDAO;
import dao.LectureDAO;
import dao.MemberDAO;
import dao.SyllabusDAO;
<<<<<<< HEAD
import vo.LectureVO;
import vo.MyLectureVO;
=======
>>>>>>> 3df762412f13eaa24611ca59fc423648917862d2

import vo.CourseVO;
import vo.LectureVO;
import vo.MyLectureVO;
import vo.SyllabusVO;
import vo.Attendance_detailVO;
@Service
public class LectureService {

	SyllabusDAO dao = new SyllabusDAO();
	LectureDAO dao2 = new LectureDAO();
<<<<<<< HEAD
	int a;
=======
	CourseDAO dao3 = new CourseDAO();
	Attendance_detailDAO dao4 = new Attendance_detailDAO();
	public void insertSyllabus(SyllabusVO vo){
		dao.insertSyllabus(vo);
	}
	public SyllabusVO searchSyllabus(int lec_no){
		SyllabusVO vo = dao.searchSyllabus(lec_no);
		return vo;
	}
	public void updateSyllabus(SyllabusVO vo){
		dao.updateSyllabus(vo);
>>>>>>> 3df762412f13eaa24611ca59fc423648917862d2

	}
	public ArrayList<MyLectureVO> lectureList(String id) {
		ArrayList<MyLectureVO> list = dao.myLectureList(id);
		return list;
	}
<<<<<<< HEAD
	
	public ArrayList<LectureVO> Alllecturelist(String student_id){
		ArrayList<LectureVO> alllist = dao2.lectureAllList(student_id);
		return alllist;
	}
}
=======

	public void insertLecture(LectureVO vo){
		dao2.insertLecture(vo);
	}
	public LectureVO searchLecture(int lec_no){
		LectureVO vo = dao2.searchLecture(lec_no);
		return vo;
	}
	public void deleteLecture(int lec_no){
		dao2.deleteLecture(lec_no);

	}
	public void updateLecture(LectureVO vo){
		dao2.updateLecture(vo);
	}

	
	public void insertCourse(CourseVO vo){
		dao3.insertCourse(vo);
	}
	public ArrayList<CourseVO> searchCourse(String student_id){
		ArrayList<CourseVO> vo = dao3.searchCourse(student_id);
		return vo;
	}
	public void deleteCourse(int lec_no, String student_id){
		dao3.deleteCourse(lec_no, student_id);

	}
	
	
	public void insertAttDetail(Attendance_detailVO vo){
		dao4.insertAttDetail(vo);
	}
	
	public void updateAttDetail(Attendance_detailVO vo) {
		dao4.updateAttDetail(vo);
	}
}
>>>>>>> 3df762412f13eaa24611ca59fc423648917862d2

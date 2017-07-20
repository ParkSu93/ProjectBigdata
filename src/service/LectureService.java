package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.Attendance_detailDAO;
import dao.CourseDAO;
import dao.LectureDAO;
import dao.SyllabusDAO;
import vo.Attendance_bookVO;
import vo.Attendance_detailVO;
import vo.CourseVO;
import vo.LectureVO;
import vo.MyLectureVO;
import vo.SearchAttBookVO;
import vo.SyllabusVO;
@Service
public class LectureService {

	static SyllabusDAO syllaDao = new SyllabusDAO();
	static LectureDAO lecDao = new LectureDAO();
	static CourseDAO corseDao = new CourseDAO();
	static Attendance_detailDAO attDao = new Attendance_detailDAO();

	public void insertSyllabus(SyllabusVO vo){
		syllaDao.insertSyllabus(vo);
	}
	public SyllabusVO searchSyllabus(int lec_no){
		SyllabusVO vo = syllaDao.searchSyllabus(lec_no);
		return vo;
	}
	public void updateSyllabus(SyllabusVO vo){
		syllaDao.updateSyllabus(vo);

	}
	public ArrayList<MyLectureVO> lectureList(String id) {
		ArrayList<MyLectureVO> list = syllaDao.myLectureList(id);
		return list;
	}
	
	public ArrayList<LectureVO> Alllecturelist(String student_id){
		ArrayList<LectureVO> alllist = lecDao.lectureAllList(student_id);
		return alllist;
	}

	public void insertLecture(MyLectureVO vo){
		lecDao.insertLecture((LectureVO)vo);
		
		SyllabusVO ss = new SyllabusVO();
		ss.setLec_outline(vo.getLec_outline());
		ss.setLec_goal(vo.getLec_goal());
		ss.setLec_time(vo.getLec_time());
		
		System.out.println("렉쳐 서비스 실라 호출 : " + ss);
		syllaDao.insertSyllabus(ss);
	}
	
	public LectureVO searchLecture(int lec_no){
		LectureVO vo = lecDao.searchLecture(lec_no);
		return vo;
	}
	public void deleteLecture(int lec_no){
		lecDao.deleteLecture(lec_no);

	}
	public void updateLecture(LectureVO vo){
		lecDao.updateLecture(vo);
	}

	
	public void insertCourse(CourseVO vo){
		corseDao.insertCourse(vo);
	}
	public ArrayList<CourseVO> searchCourse(String student_id){
		ArrayList<CourseVO> vo = corseDao.searchCourse(student_id);
		return vo;
	}
	public void deleteCourse(int lec_no, String student_id){
		corseDao.deleteCourse(lec_no, student_id);

	}
	
	public void insertAttDetail(Attendance_detailVO vo){
		attDao.insertAttDetail(vo);
	}
	
	public void updateAttDetail(Attendance_detailVO vo) {
		attDao.updateAttDetail(vo);
	}

	public ArrayList<LectureVO> totallecturelist(String id){
		ArrayList<LectureVO> totalLecuturelist = lecDao.totalLectureList(id);
		return totalLecuturelist;
	}
}


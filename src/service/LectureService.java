package service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.LectureDAO;
import dao.MemberDAO;
import dao.SyllabusDAO;
import vo.LectureVO;
import vo.MyLectureVO;

@Service
public class LectureService {

	SyllabusDAO dao = new SyllabusDAO();
	LectureDAO dao2 = new LectureDAO();
	int a;

	public ArrayList<MyLectureVO> lectureList(String id) {
		ArrayList<MyLectureVO> list = dao.myLectureList(id);
		return list;
	}
	
	public ArrayList<LectureVO> Alllecturelist(String student_id){
		ArrayList<LectureVO> alllist = dao2.lectureAllList(student_id);
		return alllist;
	}
}

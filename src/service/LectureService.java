package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.LectureDAO;
import dao.MemberDAO;
import dao.SyllabusDAO;
import vo.MyLectureVO;

@Service
public class LectureService {

	SyllabusDAO dao = new SyllabusDAO();
	int a;

	public ArrayList<MyLectureVO> lectureList(String id) {
		ArrayList<MyLectureVO> list = dao.myLectureList(id);
		return list;
	}
}

package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dao.Attendance_bookDAO;
import dao.Attendance_detailDAO;
import vo.Attendance_detailVO;

@Service
public class AttendanceService {

	static Attendance_bookDAO attBook_dao = new Attendance_bookDAO();
	static Attendance_detailDAO attDetail_dao = new Attendance_detailDAO();
	
	public ArrayList<Attendance_detailVO> getAttendStudentList(int lec_no){
		return attDetail_dao.getAttendStudentList(lec_no); // 원준오빠가 만들꺼얌
	}
}

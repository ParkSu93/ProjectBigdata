package vo;

public class Attendance_detailVO {
	private int lec_no;
	private String student_id;
	private short day;
	private String attendance_status;
	private String report; // 기타사항

	public Attendance_detailVO() {
		super();
		attendance_status = "�Ἦ";
		report = null;
	}

	public int getLec_no() {
		return lec_no;
	}

	public void setLec_no(int lec_no) {
		this.lec_no = lec_no;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public short getDay() {
		return day;
	}

	public void setDay(short day) {
		this.day = day;
	}

	public String getAttendance_status() {
		return attendance_status;
	}

	public void setAttendance_status(String attendance_status) {
		this.attendance_status = attendance_status;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Attendance_detailVO [lec_no=" + lec_no + ", student_id=" + student_id
				+ ", day=" + day + ", attendance_status=" + attendance_status + ", report=" + report + "]";
	}

}

package vo;

public class Attendance_detailVO {
	private String detail_name;
	private int lec_no;
	private String student_id;
	private String day;
	private String attendance_status;
	private String report;

	public Attendance_detailVO() {
		super();
	}

	public String getDetail_name() {
		return detail_name;
	}

	public void setDetail_name(String detail_name) {
		this.detail_name = detail_name;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
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
		return "Attendance_detailVO [detail_name=" + detail_name + ", lec_no=" + lec_no + ", student_id=" + student_id
				+ ", day=" + day + ", attendance_status=" + attendance_status + ", report=" + report + "]";
	}

}

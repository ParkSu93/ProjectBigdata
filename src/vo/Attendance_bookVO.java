package vo;

public class Attendance_bookVO extends CourseVO {
	private byte attendance_rate;
	private short stu_start_date;
	private short stu_closing_date;

	public Attendance_bookVO() {
		super();
		attendance_rate = 0;
		stu_start_date = 1;
		stu_closing_date = 0;
	}

	public byte getAttendance_rate() {
		return attendance_rate;
	}

	public void setAttendance_rate(byte attendance_rate) {
		this.attendance_rate = attendance_rate;
	}

	public short getStu_start_date() {
		return stu_start_date;
	}

	public void setStu_start_date(short stu_start_date) {
		this.stu_start_date = stu_start_date;
	}

	public short getStu_closing_date() {
		return stu_closing_date;
	}

	public void setStu_closing_date(short stu_closing_date) {
		this.stu_closing_date = stu_closing_date;
	}

	@Override
	public String toString() {
		return "Attendance_bookVO [attendance_rate=" + attendance_rate + ", stu_start_date=" + stu_start_date
				+ ", stu_closing_date=" + stu_closing_date + "]";
	}

}

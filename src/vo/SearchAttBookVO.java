package vo;

public class SearchAttBookVO {
	private int lec_no;
	private String lec_name;
	private byte attendance_rate;
	private short stu_start_date;
	private short stu_closing_date;

	public SearchAttBookVO() {
		super();
	}

	public int getLec_no() {
		return lec_no;
	}

	public void setLec_no(int lec_no) {
		this.lec_no = lec_no;
	}

	public String getLec_name() {
		return lec_name;
	}

	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
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
		return "SearchAttBookVO [lec_no=" + lec_no + ", lec_name=" + lec_name + ", attendance_rate=" + attendance_rate
				+ ", stu_start_date=" + stu_start_date + ", stu_closing_date=" + stu_closing_date + "]";
	}

}

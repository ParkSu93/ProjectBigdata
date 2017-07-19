package vo;

public class LectureVO {
	private int lec_no;
	private String teacher_id;
	private String lec_name;
	private String lec_password;
	private short enroll_num;
	private byte completion_rate;
	private String lec_start_date;
	private String lec_closing_date;

	public LectureVO() {
		super();
		enroll_num = 0;
		completion_rate = 70;
		lec_closing_date = null;
	}

	public int getLec_no() {
		return lec_no;
	}

	public void setLec_no(int lec_no) {
		this.lec_no = lec_no;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getLec_name() {
		return lec_name;
	}

	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}

	public String getLec_password() {
		return lec_password;
	}

	public void setLec_password(String lec_password) {
		this.lec_password = lec_password;
	}

	public short getEnroll_num() {
		return enroll_num;
	}

	public void setEnroll_num(short enroll_num) {
		this.enroll_num = enroll_num;
	}

	public byte getCompletion_rate() {
		return completion_rate;
	}

	public void setCompletion_rate(byte completion_rate) {
		this.completion_rate = completion_rate;
	}

	public String getLec_start_date() {
		return lec_start_date;
	}

	public void setLec_start_date(String lec_start_date) {
		this.lec_start_date = lec_start_date;
	}

	public String getLec_closing_date() {
		return lec_closing_date;
	}

	public void setLec_closing_date(String lec_closing_date) {
		this.lec_closing_date = lec_closing_date;
	}

	@Override
	public String toString() {
		return "LectureVO [lec_no=" + lec_no + ", teacher_id=" + teacher_id + ", lec_name=" + lec_name
				+ ", lec_password=" + lec_password + ", enroll_num=" + enroll_num + ", completion_rate="
				+ completion_rate + ", lec_start_date=" + lec_start_date + ", lec_closing_date=" + lec_closing_date
				+ "]";
	}

}

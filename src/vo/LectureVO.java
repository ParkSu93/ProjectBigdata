package vo;

public class LectureVO {
	public int lec_no;
	public String teacher_id;
	public String lec_name;
	public String lec_password;
	public short enroll_num;
	public byte completion_rate;
	public short lec_total_date;
	public String lec_check;
	
	public LectureVO() {
		super();
		enroll_num = 0;
		completion_rate = 70;
		lec_total_date = 1;
		lec_check = "\'<button type=\"button\" class=\"btn btn-success btn-circle moveAttandence\"><i class=\"glyphicon glyphicon-link\"></i></button>\'";
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

	
	public short getLec_total_date() {
		return lec_total_date;
	}

	public void setLec_total_date(short lec_total_date) {
		this.lec_total_date = lec_total_date;
	}
	
	public String getLec_check() {
		return lec_check;
	}

	@Override
	public String toString() {
		return "LectureVO [lec_no=" + lec_no + ", teacher_id=" + teacher_id + ", lec_name=" + lec_name
				+ ", lec_password=" + lec_password + ", enroll_num=" + enroll_num + ", completion_rate="
				+ completion_rate + ", lec_total_date=" + lec_total_date + "]";
	}

}

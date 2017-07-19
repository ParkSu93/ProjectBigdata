package vo;

public class MyLectureVO {
	private int lec_no;
	private String lec_name;
	private short lec_total_date;
	private short enroll_num;
	private String lec_time;

	public MyLectureVO() {
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

	public short getLec_total_date() {
		return lec_total_date;
	}

	public void setLec_total_date(short lec_total_date) {
		this.lec_total_date = lec_total_date;
	}

	public short getEnroll_num() {
		return enroll_num;
	}

	public void setEnroll_num(short enroll_num) {
		this.enroll_num = enroll_num;
	}

	public String getLec_time() {
		return lec_time;
	}

	public void setLec_time(String lec_time) {
		this.lec_time = lec_time;
	}

	@Override
	public String toString() {
		return "MyLectureVO [lec_no=" + lec_no + ", lec_name=" + lec_name + ", lec_total_date=" + lec_total_date
				+ ", enroll_num=" + enroll_num + ", lec_time=" + lec_time + "]";
	}

}

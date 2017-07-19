package vo;

public class CourseVO {
	private int lec_no;
	private String student_id;

	public CourseVO() {
		super();
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

	@Override
	public String toString() {
		return "CourseVO [lec_no=" + lec_no + ", student_id=" + student_id + "]";
	}

}

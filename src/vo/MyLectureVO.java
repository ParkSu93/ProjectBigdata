package vo;

public class MyLectureVO extends LectureVO{
	private String lec_time;
	private String lec_outline;
	private String lec_goal;
	
	public MyLectureVO() {
		super();
	}

	public String getLec_time() {
		return lec_time;
	}

	public void setLec_time(String lec_time) {
		this.lec_time = lec_time;
	}

	public String getLec_outline() {
		return lec_outline;
	}

	public void setLec_outline(String lec_outline) {
		this.lec_outline = lec_outline;
	}

	public String getLec_goal() {
		return lec_goal;
	}

	public void setLec_goal(String lec_goal) {
		this.lec_goal = lec_goal;
	}


	@Override
	public String toString() {
		return "MyLectureVO [lec_no=" + lec_no + ", lec_name=" + lec_name + ", lec_total_date=" + lec_total_date
				+ ", enroll_num=" + enroll_num + ", lec_time=" + lec_time + "]";
	}

}

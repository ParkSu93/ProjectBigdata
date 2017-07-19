package vo;

public class SyllabusVO {
	private int lec_no;
	private String lec_outline;
	private String lec_goal;
	private String lec_time;

	public SyllabusVO() {
		super();
		lec_outline = null;
		lec_goal = null;
		lec_time = null;
	}

	public int getLec_no() {
		return lec_no;
	}

	public void setLec_no(int lec_no) {
		this.lec_no = lec_no;
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

	public String getLec_time() {
		return lec_time;
	}

	public void setLec_time(String lec_time) {
		this.lec_time = lec_time;
	}

	@Override
	public String toString() {
		return "SyllabusVO [lec_no=" + lec_no + ", lec_outline=" + lec_outline + ", lec_goal=" + lec_goal
				+ ", lec_time=" + lec_time + "]";
	}

}

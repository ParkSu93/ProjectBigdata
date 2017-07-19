package vo;

public class TeacherVO extends MemberVO {
	private String edu_background;
	private String career;

	public TeacherVO() {
		super();
		this.edu_background = null;
		this.career = null;
	}

	public String getEdu_background() {
		return edu_background;
	}

	public void setEdu_background(String edu_background) {
		this.edu_background = edu_background;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	@Override
	public String toString() {
		return "TeacherVO [id=" + id + ", password=" + password + ", username=" + username + ", birthday=" + birthday
				+ ", email=" + email + ", phonenum=" + phonenum + ", addr=" + addr + ", introduce=" + introduce
				+ ", teacher_flag=" + teacher_flag + ", profile=" + profile +", edu_background=" + edu_background + ", career=" + career + "]";
	}

}

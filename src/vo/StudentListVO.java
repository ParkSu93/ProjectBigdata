package vo;

import java.util.ArrayList;

public class StudentListVO {
	private String id;
	private String username;
	private String birthday;
	private String email;
	private String phonenum;
	private String addr;
	private String introduce;
	private String profile;
	private short stu_start_date;
	private short stu_closing_date;
	private byte attendance_rate;
	private ArrayList<String> attendance_status;

	public StudentListVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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

	public ArrayList<String> getAttendance_status() {
		return attendance_status;
	}

	public void setAttendance_status(ArrayList<String> attendance_status) {
		this.attendance_status = attendance_status;
	}

	@Override
	public String toString() {
		return "StudentListVO [id=" + id + ", username=" + username + ", birthday=" + birthday + ", email=" + email
				+ ", phonenum=" + phonenum + ", introduce=" + introduce + ", profile=" + profile + ", stu_start_date="
				+ stu_start_date + ", stu_closing_date=" + stu_closing_date + ", attendance_status=" + attendance_status
				+ "]";
	}

}

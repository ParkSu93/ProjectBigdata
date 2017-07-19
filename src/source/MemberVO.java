package source;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	private String id;
	private String password;
	private String username;
	private String birthday;
	private String email;
	private String phonenum;
	private String addr;
	private String introduce;
	private String teacher_flag;
	private MultipartFile profile;

	public MemberVO() {
		super();
		this.addr = null;
		this.introduce = null;
		this.teacher_flag = "N";
		this.profile = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTeacher_flag() {
		return teacher_flag;
	}

	public void setTeacher_flag(String teacher_flag) {
		this.teacher_flag = teacher_flag;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
		if (!profile.isEmpty()) {
			File file = new File("c:/logs/" + profile.getOriginalFilename());
			try {
				profile.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", username=" + username + ", birthday=" + birthday
				+ ", email=" + email + ", phonenum=" + phonenum + ", addr=" + addr + ", introduce=" + introduce
				+ ", teacher_flag=" + teacher_flag + ", profile=" + profile + "]";
	}

}

package vo;

import java.util.ArrayList;

public class ReturnAttdanceVO {
	private int lec_no;
	private String student_id;
	private short stu_start_date;
	private short stu_closing_date;
	private ArrayList<String> list = new ArrayList<String>();

	public ReturnAttdanceVO() {
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

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ReturnAttdanceVO [stu_start_date=" + stu_start_date + ", stu_closing_date=" + stu_closing_date
				+ ", list=" + list + "]";
	}

}

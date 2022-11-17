package com.SpringBoot.Student.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="student")
public class Student {
	
	
	@Id
	@Column(name = "student_id")
	private String sid;

	@Column(name = "student_name")
	private String sname;

	@Column(name = "dob")
	private String dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone_number")
	private String ph;

	@Column(name = "education")
	private String education;

	@JoinColumn
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {@JoinColumn(name = "course_id") })
	private List<Course> courses;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	/*
	 * @Override public String toString() { return "Student [sid=" + sid +
	 * ", sname=" + sname + ", dob=" + dob + ", gender=" + gender + ", ph=" + ph +
	 * ", education=" + education + ", courses=" + courses + "]"; }
	 */

}

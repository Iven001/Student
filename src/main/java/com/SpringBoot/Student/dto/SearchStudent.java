package com.SpringBoot.Student.dto;

import org.springframework.stereotype.Service;

@Service
public class SearchStudent {

	private String sid;
	private String sname;
	private String course;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
}

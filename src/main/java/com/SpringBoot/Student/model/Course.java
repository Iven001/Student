package com.SpringBoot.Student.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="course")
public class Course {
	
	@NotEmpty
	@Id
	@Column(name= "course_id")
	private String cid;
	
	@NotEmpty
	@Column(name= "cname")
	private String cname;
	
	@ManyToMany(mappedBy = "courses")
	private List <Student> students;
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "CourseEntity [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}

}

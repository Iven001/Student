package com.SpringBoot.Student.service;

import java.util.List;

import com.SpringBoot.Student.model.Course;
import com.SpringBoot.Student.model.Student;

public interface StudentService {

	List<Student> getAllStudent();
	
	Student saveStudent(Student student);
	
	Student getStudentById(String sid);
	
	void deleteStudentById(String sid);

	
	List<Student> searchbybyIdAndNameAndCourse(String cName,String sId,String sName);
	
}

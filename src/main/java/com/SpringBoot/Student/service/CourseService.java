package com.SpringBoot.Student.service;

import java.util.List;

import com.SpringBoot.Student.model.Course;

public interface CourseService {

	List<Course> getAllCourse();
	
	Course saveCourse(Course course);
	
	Course getCourseById(String cid);
	
	void deleteCourseById(String cid);
	
}

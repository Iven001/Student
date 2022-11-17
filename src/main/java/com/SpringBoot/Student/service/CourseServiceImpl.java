package com.SpringBoot.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Student.dao.CourseRepository;

import com.SpringBoot.Student.model.Course;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository coursesRepository;
	
	@Override
	public List<Course> getAllCourse() {
		List<Course> list= (List<Course>) coursesRepository.findAll();
		return list;
	}

	@Override
	public Course saveCourse(Course course) {
		return coursesRepository.save(course);
	}

	@Override
	public Course getCourseById(String cid) {
		return coursesRepository.findById(cid).get();
	}

	@Override
	public void deleteCourseById(String cid) {
		coursesRepository.deleteById(cid);
		
	}

}

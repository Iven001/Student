package com.SpringBoot.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Student.dao.StudentRepository;
import com.SpringBoot.Student.model.Course;
import com.SpringBoot.Student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentsRepository;
	
	
	@Override
	public List<Student> getAllStudent() {
		List<Student> list=(List<Student>) studentsRepository.findAll();
		return list;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentsRepository.save(student);
	}

	@Override
	public Student getStudentById(String sid) {
		return studentsRepository.findById(sid).get();
	}

	@Override
	public void deleteStudentById(String sid) {
		studentsRepository.deleteById(sid);
		
	}
	
	@Override
	public List<Student> searchbybyIdAndNameAndCourse(String cName, String sId, String sName) {
		List<Student> list= studentsRepository.searchbyIdAndNameAndCourse(cName, sId, sName);
		return list;
	}

	
}

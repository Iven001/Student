package com.SpringBoot.Student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Student.model.Course;
import com.SpringBoot.Student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	
	@Query("SELECT s FROM Student s INNER JOIN s.courses c WHERE c.cname=:cName OR s.sid=:sId OR s.sname=:sName")
	List<Student> searchbyIdAndNameAndCourse(String cName,String sId,String sName);
	
}

package com.SpringBoot.Student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Student.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}

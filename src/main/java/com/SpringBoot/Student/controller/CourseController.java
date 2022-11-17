package com.SpringBoot.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBoot.Student.model.Course;
import com.SpringBoot.Student.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@ModelAttribute("courseBean")
	public Course getCourse() {
		return new Course();
	}
	
	/*
	 * @GetMapping("/allCourse") public String Allstudent(ModelMap model) {
	 * List<Course> list= courseService.getAllCourse();
	 * model.addAttribute("list",list); return "STU001"; }
	 */
	
	@GetMapping("/toaddCourse")
	public ModelAndView Toadd() {
		return new ModelAndView("BUD003","courseBean", new Course());
	}
	
	@PostMapping("/addCourse")
	public String Addstudent(@ModelAttribute("courseBean") @Validated Course bean,BindingResult bs,ModelMap model) {
		if (bs.hasErrors()) {
			return "BUD003";
		}
		if(bean.getCid().equals("") || bean.getCname().equals("") ) {			
		model.addAttribute("error","Pls Check Your Data");
		return "BUD003" ;
		}
		
		Course course= new Course();
		course.setCid(bean.getCid());
		course.setCname(bean.getCname());
		courseService.saveCourse(course);
		return "MUN001";
	}
	
	
	
}

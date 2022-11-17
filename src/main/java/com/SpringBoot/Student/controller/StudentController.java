package com.SpringBoot.Student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBoot.Student.dto.SearchStudent;
import com.SpringBoot.Student.model.Course;
import com.SpringBoot.Student.model.Student;
import com.SpringBoot.Student.service.CourseService;
import com.SpringBoot.Student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	
	  @Autowired SearchStudent dto;
	 

	@ModelAttribute("studentBean")
	public Student getStudent() {
		return new Student();
	}

	@ModelAttribute("courseBean")
	public Course getCourse() {
		return new Course();
	}
	
	@ModelAttribute("dto")
	public SearchStudent getSearchStudent() {
		return new SearchStudent();
	}

	@GetMapping("/allStudent")
	public String Allstudent(ModelMap model) {
		List<Student> stu = studentService.getAllStudent();
		model.addAttribute("list", stu);
		return "STU004";
	}

	@GetMapping("/toaddStudent")
	public ModelAndView Toadd(ModelMap model) {
		List<Course> clist = courseService.getAllCourse();
		model.addAttribute("clist", clist);
		return new ModelAndView("STU001", "studentBean", new Student());
	}

	@PostMapping("/addStudent")
	public String Addstudent(@ModelAttribute("studentBean") @Validated Student bean, BindingResult bs, ModelMap model) {
		if (bs.hasErrors()) {
			return "STU001";
		}
		if (bean.getSid().equals("") || bean.getSname().equals("") || bean.getDob().equals("")
				|| bean.getGender().equals("") || bean.getPh().equals("") || bean.getEducation().equals("")) {

			model.addAttribute("error", "Pls Check Your Data");
			return "STU001";
		}

		Student student = new Student();
		student.setSid(bean.getSid());
		student.setSname(bean.getSname());
		student.setDob(bean.getDob());
		student.setGender(bean.getGender());
		student.setPh(bean.getPh());
		student.setEducation(bean.getEducation());
		student.setCourses(bean.getCourses());
		studentService.saveStudent(student);
		return "redirect:/allStudent";
	}

	@GetMapping("/toupdate/{id}")
	public ModelAndView Toupdatestudent(@PathVariable("id") String sid, ModelMap model) {
		List<Course> clist = courseService.getAllCourse();
		model.addAttribute("clist", clist);
		return new ModelAndView("STU002", "studentBean", studentService.getStudentById(sid));
	}

	@PostMapping("/updateStudent")
	public String Updatestudent(@ModelAttribute("studentBean") @Validated Student bean, BindingResult bs,
			ModelMap model) {
		if (bs.hasErrors()) {
			return "USR002";
		}

		if (bean.getSid().equals("") || bean.getSname().equals("") || bean.getDob().equals("")
				|| bean.getGender().equals("") || bean.getPh().equals("") || bean.getEducation().equals("")) {

			model.addAttribute("error", "Pls Check Your Data");
			return "STU002";
		}
		Student student = new Student();
		student.setSid(bean.getSid());
		student.setSname(bean.getSname());
		student.setDob(bean.getDob());
		student.setGender(bean.getGender());
		student.setPh(bean.getPh());
		student.setEducation(bean.getEducation());
		student.setCourses(bean.getCourses());
		/* System.out.println(bean.getCourses()+"hello"); */
		studentService.saveStudent(student);
		return "redirect:/allStudent";
	}

	@GetMapping("/deleteStudent")
	public String Deleteuser(@RequestParam("id") String sid, ModelMap model) {
		studentService.deleteStudentById(sid);
		return "redirect:/allStudent";
	}

	
	@PostMapping("/search3")
	public ModelAndView searchStudents (@ModelAttribute ("dto") SearchStudent dto) {
		ModelAndView mav = new ModelAndView("STU004");
		List <Student> studentList = studentService.searchbybyIdAndNameAndCourse(dto.getCourse(),dto.getSid(),dto.getSname());
		mav.addObject("list",studentList);
		dto.setSid("");
		dto.setSname("");
		dto.setCourse("");
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/student")
	public ModelAndView studentDetail(@RequestParam ("id") String sid,@ModelAttribute("studentBean") @Validated Student studentBean) {
		ModelAndView mav = new ModelAndView ("STU002");
		Student stu2 = studentService.getStudentById(sid);
		studentBean.setSid(stu2.getSid());
		studentBean.setSname(stu2.getSname());
		studentBean.setDob(stu2.getDob());
		studentBean.setGender(stu2.getGender());
		studentBean.setPh(stu2.getPh());
		studentBean.setEducation(stu2.getEducation());
		studentBean.setCourses(stu2.getCourses());
		mav.addObject("studentBean", studentBean);
		return mav;
	}
	
	@GetMapping("/to")
	public ModelAndView setupUpdate(@RequestParam("id") String sid) {
			return new ModelAndView("STU002","studentBean",studentService.getStudentById(sid));
			}
	

}

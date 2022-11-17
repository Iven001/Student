package com.SpringBoot.Student.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.SpringBoot.Student.model.User;
import com.SpringBoot.Student.service.CourseService;
import com.SpringBoot.Student.service.UserService;





@Controller
public class WelcomeController {
	
	@Autowired
	private CourseService courseService;
	
	@ModelAttribute("courseBean")
	public Course getCourse() {
		return new Course();
	}
	
	
	@Autowired
	private UserService userService;
	

	@ModelAttribute("userBean")
	public User getUser() {
		return new User();
	}
	
	@GetMapping("/")
	public ModelAndView login() {
		return new ModelAndView ("LGN001","userBean",new User());
	}
	
	@PostMapping("/login")
	public String welcome(@ModelAttribute("userBean") @Validated User userBean, ModelMap model,BindingResult bs,HttpServletRequest request, HttpServletResponse response
			,@ModelAttribute("courseBean") Course bean2) {
		/*
		 * if (bs.hasErrors()) { return "redirect:/"; }
		 */
		/*
		 * if (bean.getUname().equals("") || bean.getPassword().equals("")) {
		 * model.addAttribute("error", "Please fill the missing data!"); return
		 * "LGN001"; }
		 */
		 
		
		String id=userBean.getUid();
		String name=userBean.getUname();
		String password=userBean.getPassword();
		
		LocalDate date= LocalDate.now();
		List <User> res = userService.getAllUser();
		for(User x: res) {
			
			if(x.getUname().equals(name)&&x.getPassword().equals(password)&&x.getRole().equals("User")) {
				HttpSession s=request.getSession();
				s.setAttribute("name", x.getUname());
				s.setAttribute("id", x.getUid());
				s.setAttribute("user", x.getRole());
				s.setAttribute("date", date);
				return "UserMenu";
			}
		}
		
		for(User y: res) {
			
			if(y.getUname().equals(name)&&y.getPassword().equals(password)&&y.getRole().equals("Admin")) {
				HttpSession a=request.getSession();
				a.setAttribute("name", y.getUname());
				a.setAttribute("id", y.getUid());
				a.setAttribute("user", y.getRole());
				a.setAttribute("date", date);
				return "MUN001";
			}
		}
		model.addAttribute("error", "Please check your data again.");
		return "LGN001";
	}

	@GetMapping("/tologout")
	public String Logout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/toaddu2")
	public ModelAndView Addu() {
		return new ModelAndView ("USR000-1","userBean",new User());
	}
	
	@GetMapping("/welcome")
	public String Towelcome() {
		return "MUN001";
	}
	

}

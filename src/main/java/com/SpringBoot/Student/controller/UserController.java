package com.SpringBoot.Student.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBoot.Student.model.User;
import com.SpringBoot.Student.service.UserService;
import com.SpringBoot.Student.service.UserServiceImpl;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@ModelAttribute("userBean")
	public User getUser() {
		return new User();
	}
	
	@GetMapping("/allUser")
	public String Alluser(ModelMap model) {
		List<User> list= userService.getAllUser();
		model.addAttribute("list",list);
		return "USR003";
	}
	
	@GetMapping("/toaddUser")
	public ModelAndView Toadd() {
		return new ModelAndView ("USR001","userBean", new User());
	}
	
	@PostMapping("/addUser")
	public String Adduser(@ModelAttribute("userBean") @Validated User bean,BindingResult bs,ModelMap model) {
		if (bs.hasErrors()) {
			return "USR001";
		}
		if(bean.getUid().equals("") || bean.getUname().equals("") || bean.getPassword().equals("") || bean.getEmail().equals("") || 
			bean.getRole().equals("")) {
					
			model.addAttribute("error","Pls Check Your Data");
			return "USR001" ;
				}
		
		User user= new User();
		user.setUid(bean.getUid());
		user.setUname(bean.getUname());
		user.setEmail(bean.getEmail());
		user.setPassword(bean.getPassword());
		user.setRole(bean.getRole());
		userService.saveUser(user);
		return "redirect:/allUser";
	}
	
	@PostMapping("/newUser")
	public String Newuser(@ModelAttribute("userBean") @Validated User bean,BindingResult bs,ModelMap model) {
		if (bs.hasErrors()) {
			return "USR001";
		}
		if(bean.getUid().equals("") || bean.getUname().equals("") || bean.getPassword().equals("") || bean.getEmail().equals("") || 
			bean.getRole().equals("")) {
					
			model.addAttribute("error","Pls Check Your Data");
			return "USR001" ;
				}
		
		User user= new User();
		user.setUid(bean.getUid());
		user.setUname(bean.getUname());
		user.setEmail(bean.getEmail());
		user.setPassword(bean.getPassword());
		user.setRole(bean.getRole());
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/toupdateUser/{id}")
	public ModelAndView Toupdateuser(@PathVariable ("id") String uid) {
		return new ModelAndView("USR002", "userBean", userService.getUserById(uid));
	}
	
	@PostMapping("/updateUser")
	public String updatebook(@ModelAttribute("userBean") @Validated User bean, BindingResult bs,
			ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		if (bs.hasErrors()) {
			return "USR002";
		}
		
		if(bean.getUid().equals("") || bean.getUname().equals("") || bean.getPassword().equals("") || bean.getEmail().equals("") || 
			bean.getRole().equals("")) {
						
			model.addAttribute("error","Pls Check Your Data");
			return "USR002" ;
		}
		
		 
		  String no=request.getParameter("uid");
		  User user2=new User();
		  user2.setUid(no);
		
		HttpSession s=request.getSession();
		String id=(String)s.getAttribute("id");
		/* String u=(String)s.getAttribute("name"); */
		
			if(no.equals(id)) {
				
				s.setAttribute("id", bean.getUid());
				s.setAttribute("name", bean.getUname());
				userService.saveUser(bean);
				return "redirect:/allUser";
			}
		
		
		
		User user= new User();
		user.setUid(bean.getUid());
		user.setUname(bean.getUname());
		user.setEmail(bean.getEmail());
		user.setPassword(bean.getPassword());
		user.setRole(bean.getRole());
		userService.saveUser(user);
		return "redirect:/allUser";
	}
	
	@GetMapping("/deleteUser")
	public String Deleteuser(@RequestParam("id") String uid, ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String no=request.getParameter("id");
		User user= new User();
		user.setUid(no);
		HttpSession s=request.getSession();
		String id=(String)s.getAttribute("id");
		
		if(!no.equals(id)) {
			userService.deleteUserById(no);
			 return "redirect:/allUser"; 
		}else {
			s.setAttribute("error", "Login user cannot delete!");
		}
		
		/* userService.deleteUserById(uid); */
		return "redirect:/allUser";
	}
	
	@GetMapping("/searchUser")
	public String Searchuser(@ModelAttribute("userBean") User bean,ModelMap model,
			@RequestParam("id") String uid, @RequestParam("name") String uname) {
		
		
		bean.setUid(uid);
		bean.setUname(uname);
		
		/*
		 * if(bean.getUid().equals("") || bean.getUname().equals("")) { return
		 * "redirect:/allUser"; }
		 */
		List<User> list=userService.searchbyIdAndName(uid, uname);
		model.addAttribute("list",list);
		/* model.addAttribute("userBean", userService.searchbyIdAndName(uid, uname)); */
		return "USR003";
	}
	
	
}

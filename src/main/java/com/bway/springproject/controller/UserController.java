package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService  service;
	
	@GetMapping({"/","/login"})
	public String getLogin() {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute  User user,Model model) {
		
		User usr = service.userLogin(user.getUsername(), user.getPassword());
		
		  if(usr != null) {
			  model.addAttribute("uname",user.getUsername());
			  return "Home";
		  }
		model.addAttribute("error","user not exist");
		return "LoginForm";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignupForm";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		
		service.userSignup(user);
		
		return "LoginForm";
	}
	
	  
}

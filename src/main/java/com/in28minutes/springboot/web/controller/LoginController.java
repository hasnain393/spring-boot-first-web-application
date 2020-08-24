package com.in28minutes.springboot.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.service.LoginService;
import com.in28minutes.springboot.web.service.TodoService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private 	TodoService  todoservice;
	
	

	@RequestMapping("/login")
	
	public String loginstart() {
		System.out.println("inside login");
		return "loginpage";
	}

		
	@RequestMapping("details")
	public String validate(@RequestParam String username,@RequestParam String password,ModelMap model) {
		System.out.println("details");
		System.out.println(username);
		System.out.println(password);

		
		
		model.addAttribute("user", username);
		
		model.addAttribute("pass", password);
		
		if(loginservice.checkuserpass(username, password))
		{
			return "welcome";
		}
		else {
			model.addAttribute("errorMessage", "invalid user name or password");
			return "loginpage";
		}
	}
	

	
	
}

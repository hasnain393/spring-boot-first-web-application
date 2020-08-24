package com.in28minutes.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean checkuserpass(String username,String password) {
		
		
		if(username.equals("in28Minutes")&&password.equals("12345"))
		{
		return true;
		
		
	}
		else {
			return false;
		}
		

}}

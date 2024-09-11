package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	@Autowired
	UserServiceImpl usi;
	
	@CrossOrigin
	@PostMapping("register")
	public String register(String firstname, String lastname, String username, String password, String country, String email) {
		User user=usi.findByUsername(username);
		if(user!=null) {
			return "Registration unsuccessful, User already exists<br><a href='http://192.168.1.105:5500/register.html'>Register</a>";
		} else {	
			User newUser = new User(firstname, lastname, username, password, country, email);
			usi.registerUser(newUser);
			return "User registered<br><a href='http://192.168.1.105:5500/login.html'>Login</a>";
		}
		
	}
	
	@CrossOrigin
	@PostMapping("login")
	public ModelAndView login(String username, String password, HttpSession session) {
		User user = usi.loginUser(username, password);
		if (user!=null) {
			session.setAttribute("U", user);
			return new ModelAndView("loginSuccess");
		} else {
			return new ModelAndView("loginError");
		}
	}
	
}

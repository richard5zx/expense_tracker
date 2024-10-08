package com.example.demo.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("register")
	public boolean register(String firstname, String lastname, String username, String password, String country, String email) {
		User user = usi.findByUsername(username);
		if (user == null) {// User doesn't exist in db
			User newUser = new User(firstname, lastname, username, password, country, email);
			usi.registerUser(newUser);
			return true;
		}
		return false;
	}
	
	@CrossOrigin
	@GetMapping("login")
	public User login(String username, String password, HttpSession session) {
		User user = usi.loginUser(username, password);
		if (user!=null) {
			return user;
		}
		return null;
	}
	
	/*
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
	@GetMapping("login")
	public ModelAndView gologin(String username, String password, HttpSession session) {
		User user = usi.loginUser(username, password);
		if (user!=null) {
			return new ModelAndView("loginSuccess.html");
		} else {
			return new ModelAndView("loginError.html");
		}
	}
	*/
}

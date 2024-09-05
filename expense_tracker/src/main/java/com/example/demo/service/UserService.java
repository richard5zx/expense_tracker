package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	// C
	public void registerUser(User user);
	
	// R
	public List<User> findAllUser();
	public boolean loginUser(String username, String password);
	public User findByUsername(String username);
	public User findById(int user_id);
	
	
	// U
	public void updateUser(int user_id, String username, String password);
	
	// D
	public void removeUser(int user_id);
}

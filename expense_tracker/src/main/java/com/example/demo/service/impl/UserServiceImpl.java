package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper um;

	@Override
	public void registerUser(User user) {
		um.addUser(user);
		
	}

	@Override
	public boolean loginUser(String username, String password) {
		List<User> list=um.selectByUsernameAndPassword(username, password);
		if(list.size()!=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> findAllUser() {
		return um.selectAll();
	}

	@Override
	public User findByUsername(String username) {
		List<User> list = um.selectByUsername(username);
		if(list.size()!=0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User findById(int user_id) {
		List<User> list = um.selectById(user_id);
		if(list.size()!=0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updateUser(int user_id, String username, String password) {
		List<User> list = um.selectById(user_id);
		User[] user = list.toArray(new User[1]);
		user[0].setUsername(username);
		user[0].setPassword(password);
		um.updateUser(user[0]);
		
	}

	@Override
	public void removeUser(int user_id) {
		um.deleteUser(user_id);
		
	}
	
}

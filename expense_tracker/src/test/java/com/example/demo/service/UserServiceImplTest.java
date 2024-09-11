package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

@SpringBootTest	
public class UserServiceImplTest {
	@Autowired
	UserServiceImpl usi;
	
	
	 //@Test
	 public void registerUserTest() { 
		 User user1 = new User("bob","fom","bob123","321","FIN","bob@com");
		 usi.registerUser(user1);
		 User user2 = new User("test","test","test","test","test","test");
		 usi.registerUser(user2);
	 }
	 
	 //@Test0
	 public void loginUserTest() {
		 User user1  = usi.loginUser("bob123","123");
		 assertTrue(user1==null);
		 User user2 = usi.loginUser("bob123","321");
		 assertTrue(user2!=null);
	 }
	 
	 @Test
	 public void findByUsernameTest() {
		 User user1=usi.findByUsername("15chaorh1");
		 assertTrue(user1.getFirstname().equals("Richard"));
		 User user2=usi.findByUsername("15chaorh");
		 assertTrue(user2==null);
	 }
	
	 @Test
	 public void findByIdTest() {
		 User user1=usi.findById(1);
		 assertTrue(user1.getFirstname().equals("Richard"));
		 User user2=usi.findById(0);
		 assertTrue(user2==null);
	 }
	 
	 //@Test
	 public void updateUserTest() {
		 usi.updateUser(3, "denk123", "adeeadsd");
	 }
	 
	 @Test
	 public void removeUserTest() {
		 usi.removeUser(4);
	 }
}

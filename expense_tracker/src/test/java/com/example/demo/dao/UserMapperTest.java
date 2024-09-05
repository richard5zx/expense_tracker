package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;

@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	UserMapper um;
	
	// C
	//@Test
	public void addUserTest() {
		User user1=new User("Richard","Chao","z5186293","1234","TWN","richardchao2009@gmail.com");
		um.addUser(user1);
		User user2=new User("test","test","test","test","test","test@gmail.com");
		um.addUser(user2);
	}
	
	// R
	//@Test
	public void selectAllTest() {
		List<User> list=um.selectAll();
		for(User user:list) {
			System.out.println(user.getFirstname());
		}
	}
	//@Test
	public void selectByUsernameTest() {
		List<User> list1=um.selectByUsername("z5186293");
		System.out.println("List:"+list1.get(0).getFirstname());
		assertTrue(list1.get(0).getFirstname().equals("Richard"));
		List<User> list2=um.selectByUsername("test");
		assertTrue(list2.get(0).getEmail().equals("test@gmail.com"));
		List<User> list3=um.selectByUsername("fail");
		assertTrue(list3.size()==0);
	}
	
	//@Test
	public void selectByUsernameAndPasswordTest() {
		List<User> list1 = um.selectByUsernameAndPassword("z5186293","1234");
		assertTrue(list1.get(0).getFirstname().equals("Richard"));
		List<User> list2 = um.selectByUsernameAndPassword("test","test");
		assertTrue(list2.get(0).getEmail().equals("test@gmail.com"));
	}
	
	//@Test
	public void selectByIdTest() {
		List<User> list1 = um.selectById(1);
		System.out.println();
		assertTrue(list1.get(0).getFirstname().equals("Richard"));
		List<User> list2 = um.selectById(2);
		assertTrue(list2.get(0).getEmail().equals("test@gmail.com"));
	}
	
	// U
	//@Test
	public void updateUserTest() {
		List<User> list = um.selectById(1);
		User user = list.get(0);
		user.setUsername("15chaorh1");
		user.setPassword("98765");
		um.updateUser(user);
	}
	
	// D
	//@Test
	public void deleteUserTest() {
		um.deleteUser(2);
	}
}

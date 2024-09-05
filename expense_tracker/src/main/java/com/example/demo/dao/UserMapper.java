package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	// C
	@Insert("insert into user(firstname,lastname,username,password,country,email)"
			+ " values(#{firstname},#{lastname},#{username},#{password},#{country},#{email})")
	public void addUser(User user);
	
	// R
	@Select("select * from user")
	public List<User> selectAll();
	
	@Select("select * from user where username=#{username}")
	public List<User> selectByUsername(String username);
	
	@Select("select * from user where username=#{username} and password=#{password}")
	public List<User> selectByUsernameAndPassword(String username, String password);
	
	@Select("select * from user where user_id=#{user_id}")
	public List<User> selectById(int user_id);
	
	// U
	@Update("update user set username=#{username}, password=#{password} where user_id=#{user_id}")
	public void updateUser(User user);
	
	// D
	@Delete("delete from user where user_id=#{user_id}")
	public void deleteUser(int user_id);
	
}

package com.example.demo.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User {
	private Integer user_id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String country;
	private String email;
	private Timestamp date_time;
	
	public User(String firstname, String lastname, String username, String password, String country, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.country = country;
		this.email = email;
	}
	
	public User() {
		super();
	}
	
	
}

package com.example.demo.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Expense {
	private Integer expense_id;
	private Integer user_id;
	private String category;
	private Integer expense;
	private String currency;
	private Timestamp date_time;
	
	public Expense(Integer user_id, String category, Integer expense, String currency) {
		super();
		this.user_id = user_id;
		this.category = category;
		this.expense = expense;
		this.currency = currency;
	}
	
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

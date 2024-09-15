package com.example.demo.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Expense {
	private Integer expense_id;
	private Integer user_id;
	private String category;
	private String description;
	private Integer expense;
	private String currency;
	private Timestamp timestamp;
	
	public Expense(Integer user_id, String category, String description, Integer expense, String currency) {
		super();
		this.user_id = user_id;
		this.category = category;
		this.description = description;
		this.expense = expense;
		this.currency = currency;
	}
	
	public Expense() {
		super();
	}
	
}

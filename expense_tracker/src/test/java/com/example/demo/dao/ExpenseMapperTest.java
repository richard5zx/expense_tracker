package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Expense;

@SpringBootTest
public class ExpenseMapperTest {
	@Autowired
	ExpenseMapper em;
	
	// C
	@Test
	public void addExpenseTest() {
		Expense expense = new Expense(1,"Food",12,"TWD");
		em.addExpense(expense);
	}
	
	// R
	@Test
	public void selectAllTest() {
		
	}
	@Test
	public void selectByCategoryTest() {
		
	}
	
	@Test
	public void selectByExpenseTest() {
		
	}
	
	@Test
	public void selectByCurrencyTest() {
		
	}
	
	@Test
	public void selectByTimeTest() {
		
	}
	
	// U
	@Test
	public void updateExpenseTest() {
		
	}
	
	// D
	@Test
	public void deleteExpenseTest() {
		
	}
	
}

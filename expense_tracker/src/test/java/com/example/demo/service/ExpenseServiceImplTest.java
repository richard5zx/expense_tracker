package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Expense;
import com.example.demo.service.impl.ExpenseServiceImpl;

@SpringBootTest
public class ExpenseServiceImplTest {
	@Autowired
	ExpenseServiceImpl esi;
	
	// C
	@Test
	public void addExpenseTest() {
		Expense expense1 = new Expense(3,"Travel","Hawaii",231,"USD");
		esi.addExpense(expense1);
		Expense expense2 = new Expense(6,"Bills","Wifi",12,"USD");
		esi.addExpense(expense2);
	}
	
	// R
	public void findAllExpenseTest() {
		
	}
	
	public void findByExpenseIdTest() {
		
	}
	
	public void findByCategoryTest() {
		
	}
	
	public void findByCurrencyTest() {
		
	}
	
	public void findByDateTest() {
		
	}
	
	// U
	public void updateExpenseTest() {
		
	}
	
	// D
	public void removeExpenseTest() {
		
	}
}

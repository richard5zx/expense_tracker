package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.List;

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
	//@Test
	public void addExpenseTest() {
		Expense expense1 = new Expense(3,"Travel","Hawaii",231,"USD");
		esi.addExpense(expense1);
		Expense expense2 = new Expense(6,"Bills","Wifi",12,"USD");
		esi.addExpense(expense2);
	}
	
	// R
	//@Test
	public void findAllExpenseTest() {
		List<Expense> list = esi.findAllExpense();
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
		
	}
	
	//@Test
	public void findByExpenseIdTest() {
		List<Expense> list = esi.findByExpenseId(2);
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void findByCategoryTest() {
		List<Expense> list = esi.findByCategory("food");
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void findByDescriptionTest() {
		List<Expense> list = esi.findByDescription("ll");
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void findByCurrencyTest() {
		List<Expense> list = esi.findByCurrency("aud");
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void findByDateTest() {
		Timestamp start = Timestamp.valueOf("2024-09-01 10:15:30");
		Timestamp end = Timestamp.valueOf("2024-09-14 17:30:30");
		
		List<Expense> list = esi.findByDate(start,end);	
		assertTrue(list.size()==2);
		
		start = Timestamp.valueOf("2024-09-15 09:00:00");
		end = Timestamp.valueOf("2024-09-15 09:40:30");
		list = esi.findByDate(start,end);
		assertTrue(list.size()==2);
	}
	
	// U
	//@Test
	public void updateExpenseTest() {
		esi.updateExpense(2, "Shopping","Noodles", 530, "AUD");
	}
	
	// D
	@Test
	public void removeExpenseTest() {
		esi.removeExpense(11);
	}
}

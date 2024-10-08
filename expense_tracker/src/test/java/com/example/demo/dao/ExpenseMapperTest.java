package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Expense;

@SpringBootTest
public class ExpenseMapperTest {
	@Autowired
	ExpenseMapper em;
	
	// C
	//@Test
	public void addExpenseTest() {
		Expense expense1 = new Expense(3,"Utility","Telephone bill",17,"AUD");
		em.addExpense(expense1);
		Expense expense2 = new Expense(6,"Gift","Ring",20,"EUR");
		em.addExpense(expense2);
	}
	
	// R
	//@Test
	public void selectAllTest() {
		List<Expense> list = em.selectAll();
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void selectByExpenseIdTest() {
		List<Expense> list = em.selectByExpenseId(1);
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void selectByCategoryTest() {
		List<Expense> list = em.selectByCategory("Food");
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void selectByDescriptionTest() {
		List<Expense> list = em.selectByDescription("urger");
		System.out.println(list.size());
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void selectByExpenseTest() {
		List<Expense> list = em.selectByExpense(1,12);
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	//@Test
	public void selectByCurrencyTest() {
		List<Expense> list = em.selectByCurrency("TWD");
		for (Expense expense:list) {
			System.out.println(expense.getExpense());
		}
	}
	
	@Test
	public void selectByDateTest() {
		Timestamp start = Timestamp.valueOf("2024-09-01 10:15:30");
		Timestamp end = Timestamp.valueOf("2024-09-14 17:30:30");
		
		List<Expense> list = em.selectByDate(start,end);	
		assertTrue(list.size()==2);
		
		start = Timestamp.valueOf("2024-09-15 09:00:00");
		end = Timestamp.valueOf("2024-09-15 09:40:30");
		list = em.selectByDate(start,end);
		assertTrue(list.size()==2);
	}
	
	// U
	//@Test
	public void updateExpenseTest() {
		List<Expense> list = em.selectByExpenseId(2);
		Expense expense = list.get(0);
		expense.setCategory("Random");
		expense.setDescription("poop");
		expense.setCurrency("AUD");
		expense.setExpense(30);
		em.updateExpense(expense);
	}
	
	// D
	//@Test
	public void deleteExpenseTest() {
		em.deleteExpense(6);
		em.deleteExpense(7);
	}
	
}

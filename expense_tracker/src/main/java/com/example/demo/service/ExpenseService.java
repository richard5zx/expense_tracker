package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo.model.Expense;

public interface ExpenseService {
	// C
	public void addExpense(Expense expense);
	
	// R
	public List<Expense> findAllExpense();
	public List<Expense> findByExpenseId(int expense_id);
	public List<Expense> findByCategory(String category);
	public List<Expense> findByCurrency(String currency);
	public List<Expense> findByDate(Timestamp dateStart, Timestamp dateEnd);
	
	// U
	public void updateExpense(int expense_id, String category, int expense, String currency);
	
	// D
	public void removeExpense(int expense_id);
}

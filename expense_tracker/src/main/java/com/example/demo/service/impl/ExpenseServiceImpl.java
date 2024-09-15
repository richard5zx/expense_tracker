package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.ExpenseService;
import com.example.demo.dao.ExpenseMapper;
import com.example.demo.model.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	ExpenseMapper em;

	@Override
	public void addExpense(Expense expense) {
		em.addExpense(expense);
	}

	@Override
	public List<Expense> findAllExpense() {
		return em.selectAll();
	}

	@Override
	public List<Expense> findByExpenseId(int expense_id) {
		return em.selectByExpenseId(expense_id);
	}

	@Override
	public List<Expense> findByCategory(String category) {
		return em.selectByCategory(category);
	}
	
	@Override
	public List<Expense> findByDescription(String description) {
		String input="%"+description+"%";
		return em.selectByDescription(input);
	}

	@Override
	public List<Expense> findByCurrency(String currency) {
		return em.selectByCurrency(currency);
	}

	@Override
	public List<Expense> findByDate(Timestamp dateStart, Timestamp dateEnd) {
		return em.selectByDate(dateStart, dateEnd);
	}

	@Override
	public void updateExpense(int expense_id, String category, String description, int expense, String currency) {
		List<Expense> list = em.selectByExpenseId(expense_id);
		Expense expenses[] = list.toArray(new Expense[1]);
		expenses[0].setCategory(category);
		expenses[0].setDescription(description);
		expenses[0].setExpense(expense);
		expenses[0].setCurrency(currency);
		em.updateExpense(expenses[0]);
		
	}

	@Override
	public void removeExpense(int expense_id) {
		em.deleteExpense(expense_id);
	}
}

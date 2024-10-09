package com.example.demo.controller.expense;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.service.impl.ExpenseServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("expense")
public class ExpenseController {
	@Autowired ExpenseServiceImpl esi;
	
	@GetMapping("showAllExpenses")
	public List<Expense> listExpenses() {
		return esi.findAllExpense();
	}
	
	@PostMapping("addExpense")
	public void addExpense(int user_id, String category, String description, Integer expense, String currency) {
		Expense new_expense = new Expense(user_id, category, description, expense, currency);
		esi.addExpense(new_expense);
	}
	
	@PostMapping("updateExpense")
	public void updateExpense(int expense_id, String category, String description, int expense, String currency) {
		esi.updateExpense(expense_id, category, description, expense, currency);
	}
	
	@DeleteMapping("removeExpense")
	public void removeExpense(int expense_id) {
		esi.removeExpense(expense_id);
	}

}

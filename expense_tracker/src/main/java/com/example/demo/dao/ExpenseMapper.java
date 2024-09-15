package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Expense;

@Mapper
public interface ExpenseMapper {
	// C
	@Insert("insert into expense(user_id,category,description,expense,currency)"
			+ " values(#{user_id},#{category},#{description},#{expense},#{currency})")
	public void addExpense(Expense expense);
	
	// R
	@Select("select * from expense")
	public List<Expense> selectAll();
	
	@Select("select * from expense where expense_id=#{expense_id}")
	public List<Expense> selectByExpenseId(int id);
	
	@Select("select * from expense where category=#{category}")
	public List<Expense> selectByCategory(String category);
	
	@Select("select * from expense where description like #{description}")
	public List<Expense> selectByDescription(String description);
	
	@Select("select * from expense where expense between #{start} and #{end}")
	public List<Expense> selectByExpense(int start, int end);
	
	@Select("select * from expense where currency=#{currency}")
	public List<Expense> selectByCurrency(String currency);
	
	@Select("select * from expense where timestamp between #{start} and #{end}")
	public List<Expense> selectByDate(Timestamp start, Timestamp end);
	
	// U
	@Update("update expense set category=#{category},description=#{description},expense=#{expense},currency=#{currency} where expense_id=#{expense_id}")
	public void updateExpense(Expense expense);
	
	// D
	@Delete("delete from expense where expense_id=#{expense_id}")
	public void deleteExpense(int expense_id);
}

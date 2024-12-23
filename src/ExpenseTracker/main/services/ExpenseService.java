/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExpenseTracker.main.services;

/**
 *
 * @author ADMIN
 */
import ExpenseTracker.main.dao.ExpenseDAO;
import ExpenseTracker.main.models.Expense;

import java.sql.SQLException;
import java.util.List;

public class ExpenseService {
    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    public List<Expense> getExpenses() throws SQLException {
        return expenseDAO.getAllExpenses();
    }

    public void addExpense(Expense expense) throws SQLException {
        expenseDAO.addExpense(expense);
    }
}
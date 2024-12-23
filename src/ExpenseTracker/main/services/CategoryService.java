/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExpenseTracker.main.services;

/**
 *
 * @author ADMIN
 */
import ExpenseTracker.main.dao.CategoryDAO;
import ExpenseTracker.main.models.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    public List<Category> getCategories() throws SQLException {
        return categoryDAO.getAllCategories();
    }

    public void addCategory(Category category) throws SQLException {
        categoryDAO.addCategory(category);
    }
}

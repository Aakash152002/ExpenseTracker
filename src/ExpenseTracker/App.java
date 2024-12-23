/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ExpenseTracker;
import ExpenseTracker.main.models.Expense;
import ExpenseTracker.main.models.Category;
import ExpenseTracker.main.services.ExpenseService;
import ExpenseTracker.main.services.CategoryService;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();
        CategoryService categoryService = new CategoryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add a new category");
            System.out.println("2. View all categories");
            System.out.println("3. Add a new expense");
            System.out.println("4. View all expenses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter category name: ");
                        String categoryName = scanner.nextLine();
                        categoryService.addCategory(new Category(0, categoryName));
                        System.out.println("Category added successfully!");
                        break;

                    case 2:
                        System.out.println("Categories:");
                        categoryService.getCategories().forEach(category -> 
                                System.out.println("ID: " + category.getId() + ", Name: " + category.getName()));
                        break;

                    case 3:
                        System.out.print("Enter expense description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter expense amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter expense date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter category ID: ");
                        int categoryId = scanner.nextInt();

                        Expense expense = new Expense(0, description, amount, date, categoryId);
                        expenseService.addExpense(expense);
                        System.out.println("Expense added successfully!");
                        break;

                    case 4:
                        System.out.println("Expenses:");
                        expenseService.getExpenses().forEach(exp -> 
                                System.out.println("ID: " + exp.getId() +
                                                   ", Description: " + exp.getDescription() +
                                                   ", Amount: " + exp.getAmount() +
                                                   ", Date: " + exp.getDate() +
                                                   ", Category ID: " + exp.getCategoryId()));
                        break;

                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}


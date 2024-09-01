package PersoFI.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String DB_URL = "jdbc:sqlite:persofi.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            // Create Users table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                         "id TEXT PRIMARY KEY," +
                         "username TEXT NOT NULL UNIQUE," +
                         "password_hash TEXT NOT NULL," +
                         "email TEXT NOT NULL UNIQUE)");

            // Create Accounts table
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (" +
                         "id TEXT PRIMARY KEY," +
                         "name TEXT NOT NULL," +
                         "balance REAL NOT NULL," +
                         "user_id TEXT NOT NULL," +
                         "FOREIGN KEY (user_id) REFERENCES users(id))");

            // Create Categories table
            stmt.execute("CREATE TABLE IF NOT EXISTS categories (" +
                         "id TEXT PRIMARY KEY," +
                         "name TEXT NOT NULL," +
                         "user_id TEXT NOT NULL," +
                         "FOREIGN KEY (user_id) REFERENCES users(id))");

            // Create Transactions table
            stmt.execute("CREATE TABLE IF NOT EXISTS transactions (" +
                         "id TEXT PRIMARY KEY," +
                         "date TEXT NOT NULL," +
                         "amount REAL NOT NULL," +
                         "description TEXT," +
                         "type TEXT NOT NULL," +
                         "account_id TEXT NOT NULL," +
                         "category_id TEXT NOT NULL," +
                         "FOREIGN KEY (account_id) REFERENCES accounts(id)," +
                         "FOREIGN KEY (category_id) REFERENCES categories(id))");

            // Create Budgets table
            stmt.execute("CREATE TABLE IF NOT EXISTS budgets (" +
                         "id TEXT PRIMARY KEY," +
                         "name TEXT NOT NULL," +
                         "user_id TEXT NOT NULL," +
                         "FOREIGN KEY (user_id) REFERENCES users(id))");

            // Create BudgetYears table
            stmt.execute("CREATE TABLE IF NOT EXISTS budget_years (" +
                         "id TEXT PRIMARY KEY," +
                         "year INTEGER NOT NULL," +
                         "budget_id TEXT NOT NULL," +
                         "FOREIGN KEY (budget_id) REFERENCES budgets(id))");

            // Create BudgetMonths table
            stmt.execute("CREATE TABLE IF NOT EXISTS budget_months (" +
                         "id TEXT PRIMARY KEY," +
                         "month INTEGER NOT NULL," +
                         "planned_amount REAL NOT NULL," +
                         "actual_amount REAL NOT NULL," +
                         "budget_year_id TEXT NOT NULL," +
                         "category_id TEXT NOT NULL," +
                         "FOREIGN KEY (budget_year_id) REFERENCES budget_years(id)," +
                         "FOREIGN KEY (category_id) REFERENCES categories(id))");

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}

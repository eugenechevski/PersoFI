package PersoFI.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String DB_URL = "jdbc:sqlite:finance.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            // Create Transactions table
            stmt.execute("CREATE TABLE IF NOT EXISTS transactions (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "date TEXT NOT NULL," +
                         "amount REAL NOT NULL," +
                         "category TEXT NOT NULL," +
                         "description TEXT)");

            // Create Categories table
            stmt.execute("CREATE TABLE IF NOT EXISTS categories (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT NOT NULL UNIQUE)");

            // Create Budgets table
            stmt.execute("CREATE TABLE IF NOT EXISTS budgets (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "category_id INTEGER," +
                         "amount REAL NOT NULL," +
                         "month INTEGER NOT NULL," +
                         "year INTEGER NOT NULL," +
                         "FOREIGN KEY (category_id) REFERENCES categories(id))");

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
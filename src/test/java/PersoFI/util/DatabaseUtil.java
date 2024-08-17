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
            
            // Create Transactions table
            stmt.execute("CREATE TABLE IF NOT EXISTS transactions (" +
                         "id TEXT PRIMARY KEY," +
                         "date TEXT NOT NULL," +
                         "amount REAL NOT NULL," +
                         "category TEXT NOT NULL," +
                         "description TEXT," +
                         "type TEXT NOT NULL)");

            // Create other tables as needed...

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
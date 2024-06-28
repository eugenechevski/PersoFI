package PersoFI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BudgetManager {

    private static final String DB_URL = "jdbc:sqlite:finance.db";

    public static void setBudget(int userId, String category, double amount, int month, int year) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "INSERT INTO budgets (user_id, category, amount, month, year) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setString(2, category);
        pstmt.setDouble(3, amount);
        pstmt.setInt(4, month);
        pstmt.setInt(5, year);
        pstmt.executeUpdate();
        conn.close();
    }

    public static List<Budget> getBudgets(int userId) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "SELECT * FROM budgets WHERE user_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();
        List<Budget> budgets = new ArrayList<>();
        while (rs.next()) {
            Budget budget = new Budget(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getInt("month"),
                    rs.getInt("year"));
            budgets.add(budget);
        }
        conn.close();
        return budgets;
    }
}

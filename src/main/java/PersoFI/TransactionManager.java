package PersoFI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private static final String DB_URL = "jdbc:sqlite:finance.db";

    public static void addTransaction(int userId, String category, double amount, String date, String description) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "INSERT INTO transactions (user_id, category, amount, date, description) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        pstmt.setString(2, category);
        pstmt.setDouble(3, amount);
        pstmt.setString(4, date);
        pstmt.setString(5, description);
        pstmt.executeUpdate();
        conn.close();
    }

    public static void editTransaction(int transactionId, String category, double amount, String date, String description) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "UPDATE transactions SET category = ?, amount = ?, date = ?, description = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, category);
        pstmt.setDouble(2, amount);
        pstmt.setString(3, date);
        pstmt.setString(4, description);
        pstmt.setInt(5, transactionId);
        pstmt.executeUpdate();
        conn.close();
    }

    public static void deleteTransaction(int transactionId) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "DELETE FROM transactions WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, transactionId);
        pstmt.executeUpdate();
        conn.close();
    }

    public static List<Transaction> getTransactions(int userId) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL);
        String sql = "SELECT * FROM transactions WHERE user_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();
        List<Transaction> transactions = new ArrayList<>();
        while (rs.next()) {
            Transaction transaction = new Transaction(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getString("category"),
                rs.getDouble("amount"),
                rs.getString("date"),
                rs.getString("description")
            );
            transactions.add(transaction);
        }
        conn.close();
        return transactions;
    }
}
package PersoFI.dao;

import PersoFI.model.Transaction;
import PersoFI.model.Account;
import PersoFI.model.Category;
import PersoFI.util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionDAO {

    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (id, date, amount, description, type, account_id, category_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, transaction.getId().toString());
            pstmt.setString(2, transaction.getDate().toString());
            pstmt.setDouble(3, transaction.getAmount());
            pstmt.setString(4, transaction.getDescription());
            pstmt.setString(5, transaction.getType().name());
            pstmt.setString(6, transaction.getAccount().getId().toString());
            pstmt.setString(7, transaction.getCategory().getId().toString());
            
            pstmt.executeUpdate();
        }
    }

    public List<Transaction> getAllTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                LocalDate date = LocalDate.parse(rs.getString("date"));
                double amount = rs.getDouble("amount");
                String description = rs.getString("description");
                Transaction.TransactionType type = Transaction.TransactionType.valueOf(rs.getString("type"));
                
                // Note: You'll need to fetch Account and Category objects here
                // This is a simplified version
                Account account = getAccountById(UUID.fromString(rs.getString("account_id")));
                Category category = getCategoryById(UUID.fromString(rs.getString("category_id")));

                Transaction transaction = new Transaction(date, amount, description, type, account, category);
                transaction.idProperty().set(id);
                transactions.add(transaction);
            }
        }
        
        return transactions;
    }

    // Placeholder methods - you'll need to implement these
    private Account getAccountById(UUID id) throws SQLException {
        // Fetch account from database
        return null;
    }

    private Category getCategoryById(UUID id) throws SQLException {
        // Fetch category from database
        return null;
    }

    // Add more methods as needed (e.g., updateTransaction, deleteTransaction, getTransactionById)
}        

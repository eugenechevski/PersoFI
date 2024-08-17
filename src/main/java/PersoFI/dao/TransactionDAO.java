package PersoFI.dao;

import PersoFI.model.Transaction;
import PersoFI.util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionDAO {

    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (id, date, amount, category, description, type) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, transaction.getId().toString());
            pstmt.setDate(2, java.sql.Date.valueOf(transaction.getDate()));
            pstmt.setDouble(3, transaction.getAmount());
            pstmt.setString(4, transaction.getCategory());
            pstmt.setString(5, transaction.getDescription());
            pstmt.setString(6, transaction.getType().name());

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
                Transaction transaction = new Transaction(
                        rs.getDate("date").toLocalDate(),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getString("description"),
                        Transaction.TransactionType.valueOf(rs.getString("type")));
                transactions.add(transaction);
            }
        }

        return transactions;
    }

    // Add more methods as needed (e.g., updateTransaction, deleteTransaction,
    // getTransactionById)
}
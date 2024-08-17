package PersoFI.model;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private LocalDate date;
    private double amount;
    private String category;
    private String description;
    private TransactionType type;

    public enum TransactionType {
        INCOME, EXPENSE
    }

    public Transaction(LocalDate date, double amount, String category, String description, TransactionType type) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.type = type;
    }

    // Getters and setters
    public UUID getId() { return id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    @Override
    public String toString() {
        return "Transaction{" +
               "id=" + id +
               ", date=" + date +
               ", amount=" + amount +
               ", category='" + category + '\'' +
               ", description='" + description + '\'' +
               ", type=" + type +
               '}';
    }
}
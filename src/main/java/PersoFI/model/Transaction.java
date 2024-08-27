package PersoFI.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private final ObjectProperty<UUID> id;
    private final ObjectProperty<LocalDate> date;
    private final DoubleProperty amount;
    private final StringProperty description;
    private final ObjectProperty<TransactionType> type;
    private final ObjectProperty<Account> account;
    private final ObjectProperty<Category> category;

    public enum TransactionType {
        INCOME, EXPENSE
    }

    public Transaction(UUID id, LocalDate date, double amount, String description, TransactionType type,
            Account account, Category category) {
        this.id = new SimpleObjectProperty<>(id);
        this.date = new SimpleObjectProperty<>(date);
        this.amount = new SimpleDoubleProperty(amount);
        this.description = new SimpleStringProperty(description);
        this.type = new SimpleObjectProperty<>(type);
        this.account = new SimpleObjectProperty<>(account);
        this.category = new SimpleObjectProperty<>(category);
    }

    // Getters and setters
    public UUID getId() {
        return id.get();
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public TransactionType getType() {
        return type.get();
    }

    public void setType(TransactionType type) {
        this.type.set(type);
    }

    public Account getAccount() {
        return account.get();
    }

    public void setAccount(Account account) {
        this.account.set(account);
    }

    public Category getCategory() {
        return category.get();
    }

    public void setCategory(Category category) {
        this.category.set(category);
    }
}
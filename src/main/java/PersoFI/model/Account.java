package PersoFI.model;

import javafx.beans.property.*;

import java.util.List;
import java.util.UUID;

public class Account {
    private final ObjectProperty<UUID> id;
    private final StringProperty name;
    private final DoubleProperty balance;
    private final ObjectProperty<User> user;
    private final ListProperty<Transaction> transactions;

    public Account(UUID id, String name, double balance, User user) {
        this.id = new SimpleObjectProperty<>(id);
        this.name = new SimpleStringProperty(name);
        this.balance = new SimpleDoubleProperty(balance);
        this.user = new SimpleObjectProperty<>(user);
        this.transactions = new SimpleListProperty<>(javafx.collections.FXCollections.observableArrayList());
    }

    // Getters and setters
    public UUID getId() { return id.get(); }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }

    public double getBalance() { return balance.get(); }
    public void setBalance(double balance) { this.balance.set(balance); }

    public User getUser() { return user.get(); }
    public void setUser(User user) { this.user.set(user); }
    public ObjectProperty<User> userProperty() { return user; }

    public List<Transaction> getTransactions() { return transactions.get(); }
    public void setTransactions(List<Transaction> transactions) { this.transactions.setAll(transactions); }
    public ListProperty<Transaction> transactionsProperty() { return transactions; }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        this.balance.set(this.balance.get() + transaction.getAmount());
    }
}

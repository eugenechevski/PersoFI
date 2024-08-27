package PersoFI.model;

import javafx.beans.property.*;

import java.util.List;
import java.util.UUID;

public class User {
    private final ObjectProperty<UUID> id;
    private final StringProperty username;
    private final StringProperty passwordHash;
    private final StringProperty email;
    private final ListProperty<Account> accounts;
    private final ListProperty<Budget> budgets;

    public User(UUID id, String username, String passwordHash, String email) {
        this.id = new SimpleObjectProperty<>(id);
        this.username = new SimpleStringProperty(username);
        this.passwordHash = new SimpleStringProperty(passwordHash);
        this.email = new SimpleStringProperty(email);
        this.accounts = new SimpleListProperty<>(javafx.collections.FXCollections.observableArrayList());
        this.budgets = new SimpleListProperty<>(javafx.collections.FXCollections.observableArrayList());
    }

    // Getters and setters
    public UUID getId() { return id.get(); }

    public String getUsername() { return username.get(); }
    public void setUsername(String username) { this.username.set(username); }

    public String getPasswordHash() { return passwordHash.get(); }
    public void setPasswordHash(String passwordHash) { this.passwordHash.set(passwordHash); }

    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }

    public List<Account> getAccounts() { return accounts.get(); }
    public void setAccounts(List<Account> accounts) { this.accounts.setAll(accounts); }

    public List<Budget> getBudgets() { return budgets.get(); }
    public void setBudgets(List<Budget> budgets) { this.budgets.setAll(budgets); }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void addBudget(Budget budget) {
        this.budgets.add(budget);
    }
}

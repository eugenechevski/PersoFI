package PersoFI.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.UUID;

public class Budget {
    private final ObjectProperty<UUID> id;
    private final StringProperty name;
    private final ObjectProperty<User> user;
    private final ListProperty<BudgetYear> budgetYears;

    public Budget(UUID id, String name, User user) {
        this.id = new SimpleObjectProperty<>(id);
        this.name = new SimpleStringProperty(name);
        this.user = new SimpleObjectProperty<>(user);
        this.budgetYears = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    // Getters and setters
    public UUID getId() { return id.get(); }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }

    public User getUser() { return user.get(); }
    public void setUser(User user) { this.user.set(user); }

    public List<BudgetYear> getBudgetYears() { return budgetYears.get(); }
    public void setBudgetYears(List<BudgetYear> budgetYears) { this.budgetYears.setAll(budgetYears); }

    public void addBudgetYear(BudgetYear budgetYear) {
        this.budgetYears.add(budgetYear);
    }
}

package PersoFI.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.UUID;

public class BudgetYear {
    private final ObjectProperty<UUID> id;
    private final IntegerProperty year;
    private final ObjectProperty<Budget> budget;
    private final ListProperty<BudgetMonth> budgetMonths;

    public BudgetYear(UUID id, int year, Budget budget) {
        this.id = new SimpleObjectProperty<>(id);
        this.year = new SimpleIntegerProperty(year);
        this.budget = new SimpleObjectProperty<>(budget);
        this.budgetMonths = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    // Getters and setters
    public UUID getId() { return id.get(); }

    public int getYear() { return year.get(); }
    public void setYear(int year) { this.year.set(year); }

    public Budget getBudget() { return budget.get(); }
    public void setBudget(Budget budget) { this.budget.set(budget); }

    public List<BudgetMonth> getBudgetMonths() { return budgetMonths.get(); }
    public void setBudgetMonths(List<BudgetMonth> budgetMonths) { this.budgetMonths.setAll(budgetMonths); }

    public void addBudgetMonth(BudgetMonth budgetMonth) {
        this.budgetMonths.add(budgetMonth);
    }
}
package PersoFI.model;

import javafx.beans.property.*;

import java.time.Month;

import java.util.UUID;

public class BudgetMonth {
    private final ObjectProperty<UUID> id;
    private final ObjectProperty<Month> month;
    private final DoubleProperty plannedAmount;
    private final DoubleProperty actualAmount;
    private final ObjectProperty<BudgetYear> budgetYear;

    public BudgetMonth(UUID id, Month month, double plannedAmount, double actualAmount, BudgetYear budgetYear) {
        this.id = new SimpleObjectProperty<>(id);
        this.month = new SimpleObjectProperty<>(month);
        this.plannedAmount = new SimpleDoubleProperty(plannedAmount);
        this.actualAmount = new SimpleDoubleProperty(actualAmount);
        this.budgetYear = new SimpleObjectProperty<>(budgetYear);
    }

    // Getters and setters
    public UUID getId() { return id.get(); }

    public Month getMonth() { return month.get(); }
    public void setMonth(Month month) { this.month.set(month); }

    public double getPlannedAmount() { return plannedAmount.get(); }
    public void setPlannedAmount(double plannedAmount) { this.plannedAmount.set(plannedAmount); }

    public double getActualAmount() { return actualAmount.get(); }
    public void setActualAmount(double actualAmount) { this.actualAmount.set(actualAmount); }

    public BudgetYear getBudgetYear() { return budgetYear.get(); }
    public void setBudgetYear(BudgetYear budgetYear) { this.budgetYear.set(budgetYear); }
}
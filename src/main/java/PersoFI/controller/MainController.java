package PersoFI.controller;

import PersoFI.dao.TransactionDAO;
import PersoFI.model.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class MainController {
    private TransactionDAO transactionDAO;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField amountField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField descriptionField;
    @FXML
    private ComboBox<Transaction.TransactionType> typeComboBox;

    public MainController() {
        this.transactionDAO = new TransactionDAO();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void initialize() {
        typeComboBox.getItems().setAll(Transaction.TransactionType.values());
    }

    @FXML
    private void handleAddTransaction() {
        try {
            LocalDate date = datePicker.getValue();
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();
            String description = descriptionField.getText();
            Transaction.TransactionType type = typeComboBox.getValue();

            Transaction transaction = new Transaction(date, amount, category, description, type);
            transactionDAO.addTransaction(transaction);

            showAlert("Success", "Transaction added successfully.");
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid amount. Please enter a valid number.");
        } catch (SQLException e) {
            showAlert("Error", "Failed to add transaction: " + e.getMessage());
        }
    }

    @FXML
    private void handleViewTransactions() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Transaction t : transactionDAO.getAllTransactions()) {
                sb.append(t.toString()).append("\n");
            }
            showAlert("Transactions", sb.toString());
        } catch (SQLException e) {
            showAlert("Error", "Failed to retrieve transactions: " + e.getMessage());
        }
    }

    @FXML
    private void handleSetBudget() {
        showAlert("Set Budget", "This feature is not yet implemented.");
    }

    @FXML
    private void handleViewBudget() {
        showAlert("View Budget", "This feature is not yet implemented.");
    }

    @FXML
    private void handleGenerateReport() {
        showAlert("Generate Report", "This feature is not yet implemented.");
    }

    private void clearFields() {
        datePicker.setValue(null);
        amountField.clear();
        categoryField.clear();
        descriptionField.clear();
        typeComboBox.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
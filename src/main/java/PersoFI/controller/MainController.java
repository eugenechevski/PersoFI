package main.java.PersoFI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MainController {

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAddTransaction() {
        // TODO: Implement add transaction functionality
        showAlert("Add Transaction", "This feature is not yet implemented.");
    }

    @FXML
    private void handleViewTransactions() {
        // TODO: Implement view transactions functionality
        showAlert("View Transactions", "This feature is not yet implemented.");
    }

    @FXML
    private void handleSetBudget() {
        // TODO: Implement set budget functionality
        showAlert("Set Budget", "This feature is not yet implemented.");
    }

    @FXML
    private void handleViewBudget() {
        // TODO: Implement view budget functionality
        showAlert("View Budget", "This feature is not yet implemented.");
    }

    @FXML
    private void handleGenerateReport() {
        // TODO: Implement generate report functionality
        showAlert("Generate Report", "This feature is not yet implemented.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
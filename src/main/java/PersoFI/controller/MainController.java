package PersoFI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MainController {

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAddTransaction() {
        showAlert("Add Transaction", "This feature is not yet implemented.");
    }

    @FXML
    private void handleViewTransactions() {
        showAlert("View Transactions", "This feature is not yet implemented.");
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

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
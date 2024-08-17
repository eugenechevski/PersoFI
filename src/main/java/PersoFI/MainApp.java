package PersoFI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import PersoFI.util.DatabaseUtil;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Initialize the database
            DatabaseUtil.initDatabase();
    
            // Load the main FXML file
            Parent root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));

            if (root == null) {
                throw new IllegalStateException("Unable to load FXML file");
            }
            
            primaryStage.setTitle("PersoFI - Personal Finance Manager");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error starting application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
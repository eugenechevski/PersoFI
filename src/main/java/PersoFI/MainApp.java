package main.java.PersoFI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.PersoFI.util.DatabaseUtil;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the database
        DatabaseUtil.initDatabase();

        // Load the main FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));
        
        primaryStage.setTitle("PersoFI - Personal Finance Manager");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package PersoFI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class DataVisualization extends Application {

    @Override
    public void start(Stage stage) {
        PieChart pieChart = new PieChart();
        pieChart.getData().add(new PieChart.Data("Food", 100));
        pieChart.getData().add(new PieChart.Data("Rent", 500));
        pieChart.getData().add(new PieChart.Data("Utilities", 200));
        pieChart.getData().add(new PieChart.Data("Entertainment", 150));

        Scene scene = new Scene(pieChart, 800, 600);
        stage.setTitle("Spending by Category");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

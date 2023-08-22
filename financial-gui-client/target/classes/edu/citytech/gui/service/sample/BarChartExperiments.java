package edu.citytech.gui.service.sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartExperiments extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BarChart Experiments");


        CategoryAxis xAxis  = new CategoryAxis();
        xAxis.setLabel("Devices");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        BarChart  barChart = new BarChart(xAxis, yAxis);
        barChart.setMaxWidth(800);
        barChart.setMaxHeight(800);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data("Desktop", 567));
        dataSeries1.getData().add(new XYChart.Data("Phone"  , 65));
        dataSeries1.getData().add(new XYChart.Data("Tablet"  , 23));

        barChart.getData().add(dataSeries1);


        VBox vbox = new VBox(barChart);
        Scene scene = new Scene(vbox );
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
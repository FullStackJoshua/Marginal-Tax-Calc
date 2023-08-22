package edu.citytech.gui.service._13fmanager;

import edu.citytech.gui.service.utlity.FormatUtility;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.text.Format;
import java.util.Date;


public class _13FManagersPieChart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("13F Managers, by Joshua Lim" + new Date());

        PieChart pieChart = new PieChart();

       var list =  _13FManagerService.find13FManagers("AAPL", 6);
        list.forEach( e -> {
                    PieChart.Data slice1 = new PieChart.Data(e.getManager(),e.getValueInBillions());
                    pieChart.getData().add(slice1);
                });

        double total = 0;
         for(var row : list){
             total = total + row.getValueInBillions();
         }

         updatePercentage(pieChart, total);


         String sTotal = FormatUtility.commaStyle(total,5);
        Label lblSummary = new Label("For AAPL stock total in billions: " + sTotal);
        lblSummary.setStyle("-fx-font: 24 arial");

        VBox vbox = new VBox(lblSummary );
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(pieChart);

        pieChart.setPrefWidth(700);
        pieChart.setPrefHeight(700);

        Scene scene = new Scene(vbox, 750, 750);

        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);
        primaryStage.show();
    }


    void updatePercentage(final PieChart pieChart, final double total) {
        for (final PieChart.Data data : pieChart.getData()) {
            String name = data.getName();
            double number = data.getPieValue() / total;
            data.setName("(" + FormatUtility.toPercentage(number,2)  + ") " + name);
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}




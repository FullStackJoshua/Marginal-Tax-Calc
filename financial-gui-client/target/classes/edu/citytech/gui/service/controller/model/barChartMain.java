package edu.citytech.gui.service.controller.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

import static edu.citytech.gui.service.shared.SceneRepository.getScene;

public class barChartMain extends Application {
    public static Stage globalStage;

    @Override
    public void start(Stage stage ) throws Exception{
        Parent root = FXMLLoader.load(getClass()
                .getResource("/fxml/" + getScene(1)));

        Scene scene = new Scene(root);
        stage.setTitle("13F Managers, by Joshua Lim " + new Date());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        globalStage = stage;
    }
}

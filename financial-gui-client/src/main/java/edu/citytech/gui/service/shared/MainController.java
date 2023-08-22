package edu.citytech.gui.service.shared;

import static edu.citytech.gui.service._13fmanager._13FManagersPieChartMain.globalStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.util.Date;

import static edu.citytech.gui.service.shared.SceneRepository.getScene;


public class MainController {
    @FXML
    void onSceneChange(ActionEvent event) throws IOException {
        MenuItem menuItem =(MenuItem) event.getSource();
       int sceneNo = Integer.parseInt(menuItem.getUserData().toString());
       String title = menuItem.getText();


        Parent root = FXMLLoader.load(getClass()
                .getResource("/fxml/" + getScene(sceneNo)));



        Scene scene = new Scene(root);
        globalStage.setTitle(title + " Developer Lim, Joshua " + new Date());
        globalStage.setScene(scene);
        globalStage.show();
        globalStage.setResizable(false);
    }
}

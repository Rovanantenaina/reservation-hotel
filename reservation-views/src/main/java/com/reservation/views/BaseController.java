package com.reservation.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController {

    protected void OpenNewTab(String views, int width, int height) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(views));
            Scene scene = new Scene(fxmlLoader.load(), width, height);
            Stage stage = new Stage();
            stage.setTitle("Reserver un hotel");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw e;
        }
    }
}

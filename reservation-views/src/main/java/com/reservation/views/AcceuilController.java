package com.reservation.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AcceuilController extends BaseController{


    @FXML
    protected void onBtnCompanileClick()  throws Exception {
        System.out.println("Click company!");
       OpenNewTab("filtre-view.fxml",530,300);


    }

}

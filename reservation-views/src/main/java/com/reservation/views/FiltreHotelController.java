package com.reservation.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FiltreHotelController extends BaseController {

    @FXML private TextField txtLoginAgence;
    @FXML private TextField txtPasswordAgence;

    @FXML
    protected void onClickValidateAgence() throws IOException {
        System.out.println("Click validate agence!");
        OpenNewTab("filtre-view.fxml",1024,720);
        FiltreHotelController filtre = new FiltreHotelController();

        System.out.println(txtLoginAgence.getText());
        System.out.println(txtPasswordAgence.getText());
    }
}

package com.reservation.views;

import com.reservation.views.services.ReservationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mg.reservation.reservationAgence.wsdl.Agence;
import mg.reservation.reservationAgence.wsdl.Chambre;
import mg.reservation.reservationAgence.wsdl.CheckDisponibiliteParAgenceRequest;
import mg.reservation.reservationAgence.wsdl.Hotel;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URL;
import java.time.ZoneId;
import java.util.*;

public class FiltreHotelController extends BaseController {

    ReservationService reservationService = new ReservationService();


    @FXML private TextField txtLoginAgence;
    @FXML private TextField txtPasswordAgence;
    @FXML private TextField txtAgenceName;
    @FXML private DatePicker dpDateDebut;
    @FXML private DatePicker dpDateFin;
    @FXML private TextField txtNbPerson;

    @FXML
    private TableView<Chambre> tbData;
    @FXML
    public TableColumn<Chambre, String> reference;

    @FXML
    public TableColumn<Chambre, Short> nombreLit;

    @FXML
    public TableColumn<Chambre, Float> prix;

    private  String loginAgence;
    private  String passwordAgence;
    private  short nbPerson;
    private CheckDisponibiliteParAgenceRequest hotelRequest = new CheckDisponibiliteParAgenceRequest();
    Agence agence = new Agence();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        nombreLit.setCellValueFactory(new PropertyValueFactory<>("nombreLit"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        //add your data to the table here.
      //  tbData.setItems(chambreModels);
    }
   // private ObservableList<Chambre> chambreModels = FXCollections.observableArrayList();

    @FXML
    protected void onClickSearchHotel() {
        nbPerson = Short.parseShort(txtNbPerson.getText());
        Date dateArrive = Date.from(dpDateFin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateDepart = Date.from(dpDateFin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        XMLGregorianCalendar xmlDateArrive = null;
        XMLGregorianCalendar xmlDateDepart = null;

        // Gregorian Calendar object creation
        GregorianCalendar gc = new GregorianCalendar();
        GregorianCalendar gcDep = new GregorianCalendar();

        // giving current date and time to gc
        gc.setTime(dateArrive);
        gcDep.setTime(dateDepart);

        try {
            xmlDateArrive = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gc);
            xmlDateDepart = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gcDep);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //Remplir l'agence
        agence.setNom(txtAgenceName.getText());
        agence.setLogin(txtLoginAgence.getText());
        agence.setPassword(txtPasswordAgence.getText());
        hotelRequest.setAgence(agence);

        //Remplir le critere de recherche
        hotelRequest.setDateArrivee(xmlDateArrive);
        hotelRequest.setDateDepart(xmlDateDepart);
        hotelRequest.setCapacite(nbPerson);

        Hotel hotelDispo = reservationService.findPlaceDisponible(hotelRequest);
    }

}

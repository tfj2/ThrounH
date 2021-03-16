package controllers;

import entities.Accommodation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


// setti inn return null til að losa um red ~ hell.
public class AccommodationSearchController implements Initializable {
    @FXML
    private Button searchButton;
    @FXML
    private ListView hotelList;
    @FXML
    private TextField hotelTextField;

    //o.fl.
    // breyta type í user eða annað
    private ObservableList<String> fyrstiListi = FXCollections.observableArrayList();

    // private DataFactory = new DataFactory();

    public ArrayList<Accommodation> findByLocation() {
        return null;
    }

    public ArrayList<Accommodation> findByRating() {
        return null;
    }

    public ArrayList<Accommodation> findByFacilities() {
        return null;
    }

    public ArrayList<Accommodation> findByName() {
        return null;
    }

    public ArrayList<Accommodation> findByTimePeriod() {
        return null;
    }

    @FXML
    public void searchButtonPressed() {
        System.out.println("We do be searching tho");
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {
        System.out.println("out");
        fyrstiListi.add("Hallo");
        fyrstiListi.add("er");
        fyrstiListi.add("rett");

        hotelList.setItems(fyrstiListi);
    }

}

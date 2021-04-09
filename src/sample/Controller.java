package sample;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import storage.DataFactory;
import storage.DatabaseMock;
import javax.swing.*;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

// View Controller sem bregst við view ot talar við controller
// kemur í staðinn fyrir T teymið (?)
public class Controller implements Initializable {
    private DatabaseMock data = new DatabaseMock(new DataFactory().getAllHotels());

    private AccommodationSearchController searchController = new AccommodationSearchController(data);
    @FXML
    private Button searchButton;
    @FXML
    private ListView hotelList;
    @FXML
    private TextField hotelTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private ChoiceBox priceChoice;
    public ArrayList<Accommodation> accommodationsShown = new ArrayList<>();
    @FXML
    public void searchButtonPressed() {
        ArrayList<Accommodation> theResult;

        // default gildi
        double minRating = 0.0;
        // default gildi
        double maxPrice = Double.POSITIVE_INFINITY;

        String location = locationTextField.getCharacters().toString();
        String name = hotelTextField.getCharacters().toString();

        // þarf að útfæra og hugsa út í facilities ...
        String facilities = "";
        Date from = null;
        Date to = null;

        theResult = searchController.search(location, minRating, facilities, maxPrice, name, from, to);
        hotelList.setItems(FXCollections.observableList(theResult));

        /*

        ArrayList<Accommodation> nameResult = searchController.findByName(nameQuery);
        ArrayList<Accommodation> locationResult = searchController.findByLocation(locationQuery);
        ArrayList<Accommodation> theResult = new ArrayList<>();
        // birta svo sniðmengi af öllum dúddum sem ekki empty I guess retainAll er very coolif (!locationResult.isEmpty() && !nameResult.isEmpty())
        if(!nameResult.isEmpty() && !locationResult.isEmpty()) {
            nameResult.retainAll(locationResult);
            theResult = nameResult;
        }
        else if (nameResult.isEmpty() && !locationResult.isEmpty()){
            theResult = locationResult;
        } else if (!nameResult.isEmpty() && locationResult.isEmpty()){
            theResult = nameResult;
        }

     */
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {
        ArrayList<String> PriceOption = new ArrayList<>();
        PriceOption.add(">");
        PriceOption.add("<");
        PriceOption.add("=");
        accommodationsShown = data.getAllHotels();
        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
        priceChoice.setItems(FXCollections.observableArrayList(PriceOption));
    }
}

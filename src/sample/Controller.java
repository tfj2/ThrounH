package sample;

import controllers.AccommodationSearchController;
import storage.DataFactory;
import entities.Accommodation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// View Controller sem bregst við view ot talar við controller
public class Controller implements Initializable {
    private DataFactory data = new DataFactory();

    private AccommodationSearchController searchController = new AccommodationSearchController();
    @FXML
    private Button searchButton;
    @FXML
    private ListView hotelList;
    @FXML
    private TextField hotelTextField;
    @FXML
    private TextField locationTextField;

    public ArrayList<Accommodation> accommodationsShown = new ArrayList<>();

    @FXML
    public void searchButtonPressed() {

        String locationQuery = locationTextField.getCharacters().toString();
        // String nameQuery = hotelTextField.getCharacters().toString();
        System.out.println(locationQuery);
        // sniðmengi/sammengi af locationResult, nameResult after the fact?
        ArrayList<Accommodation> locationResult = searchController.findByLocation(locationQuery);

        hotelList.setItems(FXCollections.observableList(locationResult));
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {
        accommodationsShown = data.getAccommodationsSmallConstructor();

        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
    }
}

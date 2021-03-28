package sample;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import storage.DataFactory;
import storage.DatabaseMockNonEmptyQuery;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// View Controller sem bregst við view ot talar við controller
public class Controller implements Initializable {
    private DatabaseMockNonEmptyQuery data = new DatabaseMockNonEmptyQuery(new DataFactory().getAllHotels());

    private AccommodationSearchController searchController = new AccommodationSearchController(data);
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
        String nameQuery = hotelTextField.getCharacters().toString();
        System.out.println(nameQuery);
        System.out.println(locationQuery);

        ArrayList<Accommodation> locationResult = searchController.findByLocation(locationQuery);
        ArrayList<Accommodation> nameResult = searchController.findByName(nameQuery);

        // birta svo sniðmengi af öllum dúddum I guess retainAll er very cool
        locationResult.retainAll(nameResult);
        hotelList.setItems(FXCollections.observableList(locationResult));
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {
        accommodationsShown = data.getAllHotels();
        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
    }
}

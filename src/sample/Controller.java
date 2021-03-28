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
import storage.DatabaseMock;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// View Controller sem bregst við view ot talar við controller
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

    public ArrayList<Accommodation> accommodationsShown = new ArrayList<>();

    @FXML
    public void searchButtonPressed() {

        String locationQuery = locationTextField.getCharacters().toString();
        String nameQuery = hotelTextField.getCharacters().toString();
        System.out.print(nameQuery);
        System.out.println(locationQuery);

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
        hotelList.setItems(FXCollections.observableList(theResult));
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {
        accommodationsShown = data.getAllHotels();
        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
    }
}

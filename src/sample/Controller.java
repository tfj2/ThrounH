package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

// View Controller sem bregst við view ot talar við controller
public class Controller implements Initializable {
    @FXML
    private Button searchButton;
    @FXML
    private ListView hotelList;
    @FXML
    private TextField hotelTextField;


    @FXML
    public void searchButtonPressed() {
        // taka inn checkboxes perhamps og athuga hvernig haga eigi leitinni
        // byrja að útfæra leitina sem var í sequence diagram (?)
        System.out.println("We do be searching tho");
    }
    private ObservableList<String> fyrstiListi = FXCollections.observableArrayList();

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {
        System.out.println("out");
        fyrstiListi.add("Hallo");
        fyrstiListi.add("er");
        fyrstiListi.add("rett");

        hotelList.setItems(fyrstiListi);
    }
}

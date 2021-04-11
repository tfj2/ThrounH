package sample;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import entities.Booking;
import entities.Room;
import entities.RoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import storage.DataFactory;
import storage.DatabaseMock;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;


// View Controller sem bregst við view ot talar við controller
// kemur í staðinn fyrir T teymið (?)
public class Controller implements Initializable {
    public String FromTo;
    public String From;
    public String To;

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
    private ListView roomList;
    @FXML
    private ListView roomPropertyList;
    @FXML
    private DatePicker FromDate;
    @FXML
    private DatePicker ToDate;
    @FXML
    private ListView RoomStatusView;

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

    }
    public void hotelViewMouseClicked(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        ObservableList<RoomType> theRoomTypes = FXCollections.observableArrayList();
        for(int count = 0; count<theHotel.getRoomArrayList().size(); count++){
            theRoomTypes.add(theHotel.getRoomArrayList().get(count).getRoomType());
        }
        ObservableList<Room> theRooms = FXCollections.observableArrayList(theHotel.getRoomArrayList());
        roomList.setItems(theRoomTypes);
    }

    public void roomViewMouseClicked(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        RoomType theRoom = (RoomType) roomList.getSelectionModel().getSelectedItem();
        ObservableList<String> theRoomPrice = FXCollections.observableArrayList();
        int place  = 0;
        for(int count = 0; count<theHotel.getRoomArrayList().size(); count++){
            if(theHotel.getRoomArrayList().get(count).getRoomType() == theRoom){
                place = count;
            }
        }
        theRoomPrice.add("" + theHotel.getRoomArrayList().get(place).getPrice());
        roomPropertyList.setItems(theRoomPrice);
    }
    public void FromMouseAction(ActionEvent actionEvent) {
        java.sql.Date theFromDate = java.sql.Date.valueOf(FromDate.getValue());
        From = "" + theFromDate;
        if(To == null){
        }
        else{
            FromTo = theFromDate + "_" + To ;
            System.out.print(FromTo);
        }
    }

    public void ToMouseAction(ActionEvent actionEvent) {
        java.sql.Date theToDate = java.sql.Date.valueOf(ToDate.getValue());
        To = "" + theToDate;
        if(From == null){
        }
        else{
            FromTo = From + "_" + theToDate;
            System.out.print(FromTo);
        }
    }

    public void BookingClick(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        RoomType theRoom = (RoomType) roomList.getSelectionModel().getSelectedItem();
        java.sql.Date theFromDate = null;
        java.sql.Date theToDate = null;
        if(FromTo != null){
            theFromDate = java.sql.Date.valueOf(FromDate.getValue());
            theToDate = java.sql.Date.valueOf(ToDate.getValue());
        }
        int place  = 0;
        for(int count = 0; count<theHotel.getRoomArrayList().size(); count++){
            if(theHotel.getRoomArrayList().get(count).getRoomType() == theRoom){
                place = count;
            }
        }
        Room theRoomR = theHotel.getRoomArrayList().get(place);
        if(theHotel != null && theRoomR != null && theFromDate != null && theToDate != null){
            Booking b = new Booking(theHotel, theRoomR, theFromDate, theToDate);
            System.out.println(b.getBookingDateTo());
            System.out.print(b);
        }
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {

        accommodationsShown = data.getAllHotels();
        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
    }
}

package sample;

import controllers.AccommodationBookingController;
import controllers.AccommodationSearchController;
import entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import storage.DataFactory;
import storage.DatabaseConnection;
import storage.DatabaseMock;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;


// View Controller sem bregst við view ot talar við controller
// kemur í staðinn fyrir T teymið (?)
public class Controller implements Initializable {
    public String fromTo;
    public String from;
    public String to;

    private DatabaseMock data_old = new DatabaseMock(new DataFactory().getAllHotels());
    private DatabaseConnection data = new DatabaseConnection();

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
    private TextField ratingTextField;
    @FXML
    private TextField priceTextField;
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
        ArrayList<Accommodation> hotelsResult;

        // default gildi
        double minRating = 0.0;

        String location = locationTextField.getCharacters().toString();
        String name = hotelTextField.getCharacters().toString();

        if(ratingTextField != null && !ratingTextField.getCharacters().toString().equals(""))
            minRating = Double.parseDouble(ratingTextField.getCharacters().toString());
        Date from = null;
        Date to = null;

        hotelsResult = searchController.search(location, minRating, name);
        hotelList.setItems(FXCollections.observableList(hotelsResult));

        // uppfærum room list þannig það sýni herbergi úr fyrsta hotelið í leit:


        if(hotelsResult != null) {
            Accommodation theHotel = hotelsResult.get(0);
            ArrayList<Room> roomsToShow = new ArrayList<>();

            ArrayList<Room> roomsFilteredByPrice = null;
            if(fromTo != null ){
                from = java.sql.Date.valueOf(FromDate.getValue());
                to = java.sql.Date.valueOf(ToDate.getValue());
                roomsToShow.addAll(searchController.filterRoomsByPeriod(theHotel, from, to));
            } else {
                // engin dagsetning valin, sýnum öll herbergi
                roomsToShow.addAll(theHotel.getAllRooms());
            }
            String price = priceTextField.getCharacters().toString();
            if (!price.equals("")) {
                roomsFilteredByPrice = searchController.filterRoomsByPrice(theHotel, Double.parseDouble(price));
                // snidmengi af fyrra roomsToShow og thessu...
                roomsToShow.retainAll(roomsFilteredByPrice);
            }
            // search controller inniheldur lika fall filterRoomsByPriceAndPeriod ef thid viljid frekar
            roomList.setItems(FXCollections.observableArrayList(roomsToShow));
        }
    }
    // keyrist ef ýtt á hotel
    public void hotelViewMouseClicked(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        java.sql.Date from = null;
        java.sql.Date to = null;

        // ath ad searchController inniheldur lika fall filterRoomsByPriceAndPeriod ef thid viljid frekar
        ArrayList<Room> roomsToShow = new ArrayList<>();

        ArrayList<Room> roomsFilteredByPrice = null;
        if(fromTo != null ){
            from = java.sql.Date.valueOf(FromDate.getValue());
            to = java.sql.Date.valueOf(ToDate.getValue());
            roomsToShow.addAll(searchController.filterRoomsByPeriod(theHotel, from, to));
        } else {
            // engin dagsetning valin, sýnum öll herbergi
            roomsToShow.addAll(theHotel.getAllRooms());
        }
        String price = priceTextField.getCharacters().toString();
        if (!price.equals("")) {
            roomsFilteredByPrice = searchController.filterRoomsByPrice(theHotel, Double.parseDouble(price));
            // snidmengi af fyrra roomsToShow og thessu...
            roomsToShow.retainAll(roomsFilteredByPrice);
        }
        roomList.setItems(FXCollections.observableArrayList(roomsToShow));
    }


    public void roomViewMouseClicked(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        Room theRoom = (Room) roomList.getSelectionModel().getSelectedItem();
        ObservableList<String> theRoomPrice = FXCollections.observableArrayList();
        int place  = 0;
        if (theHotel != null) {
            for(int count = 0; count<theHotel.getAllRooms().size(); count++){
                if(theHotel.getAllRooms().get(count).toString() == theRoom.toString()){
                    place = count;
                }
            }
            theRoomPrice.add("" + theHotel.getAllRooms().get(place).getPrice());
            roomPropertyList.setItems(theRoomPrice);
        }
    }
    public void fromMouseAction(ActionEvent actionEvent) {
        java.sql.Date theFromDate = java.sql.Date.valueOf(FromDate.getValue());
        from = "" + theFromDate;
        if(to == null){
        }
        else{
            fromTo = theFromDate + "_" + to;
            System.out.print(fromTo);
        }
    }

    public void toMouseAction(ActionEvent actionEvent) {
        java.sql.Date theToDate = java.sql.Date.valueOf(ToDate.getValue());
        to = "" + theToDate;
        if(from == null){
        }
        else{
            fromTo = from + "_" + theToDate;
            System.out.print(fromTo);
        }
    }

    public void bookingClick(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        Room theRoom = (Room) roomList.getSelectionModel().getSelectedItem();

        java.sql.Date theFromDate = null;
        java.sql.Date theToDate = null;
        if(fromTo != null){
            theFromDate = java.sql.Date.valueOf(FromDate.getValue());
            theToDate = java.sql.Date.valueOf(ToDate.getValue());
        }

        if(theHotel != null && theRoom != null && theFromDate != null && theToDate != null){

            Booking b = new Booking(theHotel, theRoom, theFromDate, theToDate);
            AccommodationBookingController bc = new AccommodationBookingController();
            bc.addBooking(b);
            roomList.setItems(FXCollections.observableArrayList(theHotel.getAvailableRooms(theFromDate, theToDate)));
        }
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {

        accommodationsShown = data.getAllHotels();
        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
    }
}

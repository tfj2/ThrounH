package sample;

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

        Date from = null;
        Date to = null;

        theResult = searchController.search(location, minRating, maxPrice, name);
        hotelList.setItems(FXCollections.observableList(theResult));

    }
    public void hotelViewMouseClicked(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        System.out.println(theHotel);
        java.sql.Date from = null;
        java.sql.Date to = null;

        ArrayList<Room> roomsToShow = null;

        if(fromTo != null ){
            from = java.sql.Date.valueOf(FromDate.getValue());
            to = java.sql.Date.valueOf(ToDate.getValue());
            roomsToShow = theHotel.getAvailableRooms(from, to);
        } else {
            // engin dagsetning valin, sýnum öll herbergi
            roomsToShow = theHotel.getAllRooms();
        }
        System.out.println(roomsToShow);
        //for(int count = 0; count<roomsToShow.size(); count++){
        //    theRoomTypes.add(roomsToShow.get(count).getRoomType());
        //}
        // ObservableList<Room> theRooms = FXCollections.observableArrayList(theHotel.getAllRooms());
        roomList.setItems(FXCollections.observableArrayList(roomsToShow));
    }


    public void roomViewMouseClicked(MouseEvent mouseEvent){
        Accommodation theHotel = (Accommodation) hotelList.getSelectionModel().getSelectedItem();
        Room theRoom = (Room) roomList.getSelectionModel().getSelectedItem();
        ObservableList<String> theRoomPrice = FXCollections.observableArrayList();
        int place  = 0;
        for(int count = 0; count<theHotel.getAllRooms().size(); count++){
            if(theHotel.getAllRooms().get(count).toString() == theRoom.toString()){
                place = count;
            }
        }
        theRoomPrice.add("" + theHotel.getAllRooms().get(place).getPrice());
        roomPropertyList.setItems(theRoomPrice);
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
        int place  = 0;
        /* þarf ekki fyrst Room er núna í lista en ekki RoomType
        if(theHotel != null){
            for(int count = 0; count<theHotel.getAllRooms().size(); count++){
                if(theHotel.getAllRooms().get(count).getRoomType() == theRoom){
                    place = count;
                }
            }
            theRoomR = theHotel.getAllRooms().get(place);
        }*/
        if(theHotel != null && theRoom != null && theFromDate != null && theToDate != null){

            Occupancy occupancy = new Occupancy(theFromDate, theToDate);
            theRoom.addOccupancy(occupancy);

            Booking b = new Booking(theHotel, theRoom, theFromDate, theToDate);
            System.out.println(b.getBookingDateTo());
            System.out.print(b);
            System.out.println("Room booked");
            roomList.setItems(FXCollections.observableArrayList(theHotel.getAvailableRooms(theFromDate, theToDate)));
        }
    }

    @Override
    public void initialize(URL LOCATION, ResourceBundle resources) {

        accommodationsShown = data.getAllHotels();
        hotelList.setItems(FXCollections.observableArrayList(accommodationsShown));
    }
}

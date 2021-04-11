package entities;

import controllers.AccommodationSearchController;
import storage.DataFactory;
import storage.DatabaseMock;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class Accommodation {
    private String id;
    private String name;
    // private ArrayList<>; // arraylist fyrir facilities
    private String location;
    private double rating;
    private ArrayList<Room> roomArrayList;
    private AccType type = AccType.Hotel;
    private ArrayList<String> managerIdArrayList;
    private ArrayList<Review> reviewArrayList;
    private String description;

    // ma baeta vid minni smidum,
    public Accommodation(String id, String name, String location, double rating, ArrayList<Room> roomArrayList, ArrayList<String> managerIdArrayList, ArrayList<Review> reviewArrayList, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.roomArrayList = roomArrayList;
        this.managerIdArrayList = managerIdArrayList;
        this.reviewArrayList = reviewArrayList;
        this.description = description;
    }

    public Accommodation(String id, String name, String location, ArrayList<Room> roomArrayList, ArrayList<String> managerIdArrayList) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = 0;
        this.roomArrayList = roomArrayList;
        this.managerIdArrayList = managerIdArrayList;
        this.reviewArrayList = new ArrayList<>();
        this.description = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Room> getAllRooms() {
        return roomArrayList;
    }

    public ArrayList<Room> getAvailableRooms(Date from, Date to) {
        ArrayList<Room> availableRooms = new ArrayList<>();


        return availableRooms;
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        this.roomArrayList = roomArrayList;
    }

    public ArrayList<String> getManagerIdArrayList() {
        return managerIdArrayList;
    }

    public void setManagerIdArrayList(ArrayList<String> managerIdArrayList) {
        this.managerIdArrayList = managerIdArrayList;
    }

    public ArrayList<Review> getReviewArrayList() {
        return reviewArrayList;
    }

    public void setReviewArrayList(ArrayList<Review> reviewArrayList) {
        this.reviewArrayList = reviewArrayList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        DatabaseMock data = new DatabaseMock(new DataFactory().getAllHotels());
        AccommodationSearchController searchController = new AccommodationSearchController(data);

        Accommodation testPig = data.getAllHotels().get(2);
        ArrayList<Room> roomsOfHotel = testPig.getAllRooms();
        Room roomPig = roomsOfHotel.get(3);

        Date testfrom = new Date(2020, 11, 1);
        Date testto = new Date(2020, 11, 1);
        System.out.println(roomPig);
        System.out.println(roomsOfHotel);
        System.out.println(testPig);
    }
}

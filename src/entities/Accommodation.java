package entities;

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

    public ArrayList<Room> getRoomArrayList() {
        return roomArrayList;
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
}

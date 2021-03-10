package Enities;

import java.util.ArrayList;

public class Accommodation {
    private String id;
    // private ArrayList<>; // arraylist fyrir facilities
    private String location;
    private double rating;
    private ArrayList<Room> roomArrayList;
    //private enum Type; // kann ekki enum syntax
    private ArrayList<String> managerIdArrayList;
    private ArrayList<Review> reviewArrayList;
    private String description;

    public Accommodation(String id, String location, double rating, ArrayList<Room> roomArrayList, ArrayList<String> managerIdArrayList, ArrayList<Review> reviewArrayList, String description) {
        this.id = id;
        this.location = location;
        this.rating = rating;
        this.roomArrayList = roomArrayList;
        this.managerIdArrayList = managerIdArrayList;
        this.reviewArrayList = reviewArrayList;
        this.description = description;
    }
    

}

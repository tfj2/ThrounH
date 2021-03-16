package controllers;

import entities.Accommodation;
import javafx.fxml.FXML;
import java.util.ArrayList;


// setti inn return null til að losa um red ~ hell.
public class AccommodationSearchController {


    public ArrayList<Accommodation> findByLocation() {
        return null;
    }

    public ArrayList<Accommodation> findByRating() {
        return null;
    }

    public ArrayList<Accommodation> findByFacilities() {
        return null;
    }

    public ArrayList<Accommodation> findByName() {
        return null;
    }

    public ArrayList<Accommodation> findByTimePeriod() {
        return null;
    }

    @FXML
    public void searchButtonPressed() {
        System.out.println("We do be searching tho");
    }

    public static void main (String[] args) {
        System.out.println("We in this b");
    }
}

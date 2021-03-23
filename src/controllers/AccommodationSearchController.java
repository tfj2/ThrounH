package controllers;

import entities.Accommodation;
import javafx.collections.ObservableList;
import sample.DataFactory;

import java.util.ArrayList;



public class AccommodationSearchController {
    public AccommodationSearchController() {

    }

    // breyta í mock object sem DataFactory Implementar?
    private DataFactory data = new DataFactory();
    // allar accommodations sem controller veit af
    private ObservableList<Accommodation>  accommodations = data.getAccommodations();

    public ArrayList<Accommodation> findByLocation(String query) {
        ArrayList<Accommodation> result = new ArrayList<>();
        for (Accommodation acc : accommodations) {
            if(acc.getLocation().contains(query)) {
                result.add(acc);
            }
        }
        return result;
    }

    public ArrayList<Accommodation> findByRating(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByFacilities(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByName(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByTimePeriod(String query) {
        return null;
    }
    public static void main(String[] args) {

    }

}

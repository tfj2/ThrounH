package controllers;

import entities.Accommodation;
import storage.AllHotelsMock;
import storage.DatabaseService;

import java.sql.Date;
import java.util.ArrayList;



public class AccommodationSearchController {
    private DatabaseService data = new AllHotelsMock();
    private ArrayList<Accommodation>  accommodations = data.query("");

    public AccommodationSearchController() {

    }

    public ArrayList<Accommodation> findByLocation(String query) {
        ArrayList<Accommodation> result = new ArrayList<>();
        for (Accommodation acc : accommodations) {
            // contains er case sensitive, gerum leitina það ekki
            if(acc.getLocation().toLowerCase().contains(query.toLowerCase())) {
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

    public ArrayList<Accommodation> findByPrice(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByName(String query) {
        ArrayList<Accommodation> result = new ArrayList<>();
        for (Accommodation acc : accommodations) {
            if(acc.getLocation().contains(query)) {
                result.add(acc);
            }
        }
        return result;
    }

    public ArrayList<Accommodation> findByTimePeriod(Date from, Date to) {
        return null;
    }
    public static void main(String[] args) {

    }

}

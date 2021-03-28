package controllers;

import entities.Accommodation;
import storage.Database;

import java.sql.Date;
import java.util.ArrayList;


public class AccommodationSearchController {
    private Database data;
    private ArrayList<Accommodation>  accommodations;

    public AccommodationSearchController(Database data) {

        this.data = data;
        accommodations = data.getAllHotels();
    }

    public ArrayList<Accommodation> findByLocation(String location) {
        return data.getHotelsByLocation(location);
    }

    public ArrayList<Accommodation> findByRating(double minRating) {
        return data.getHotelsByRating(minRating);
    }

    public ArrayList<Accommodation> findByFacilities(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByPrice(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByName(String name) {
        return data.getHotelsByName(name);
    }

    public ArrayList<Accommodation> findByTimePeriod(Date from, Date to) {
        return null;
    }

    public static void main(String[] args) {

    }
}

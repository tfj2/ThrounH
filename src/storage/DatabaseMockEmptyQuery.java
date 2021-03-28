package storage;

import entities.Accommodation;

import java.util.ArrayList;

public class DatabaseMockEmptyQuery implements Database {

    ArrayList<Accommodation> accommodations;

    public DatabaseMockEmptyQuery(ArrayList<Accommodation> mockData) {
        this.accommodations = mockData;
    }

    @Override
    public ArrayList<Accommodation> getAllHotels() {
        return accommodations;
    }
    @Override
    public ArrayList<Accommodation> getHotelsByLocation(String location) {
        return null;
    }

    @Override
    public ArrayList<Accommodation> getHotelsByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Accommodation> getHotelsByRating(double minRating) {
        return null;
    }
}

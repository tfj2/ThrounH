package storage;

import entities.Accommodation;

import java.util.ArrayList;

public interface Database {
    ArrayList<Accommodation> getAllHotels();
    ArrayList<Accommodation> getHotelsByLocation(String location);
    //ArrayList<Accommodation> getHotelsByTimePeriod(String location);
    ArrayList<Accommodation> getHotelsByRating(double minRating);
    //ArrayList<Accommodation> getHotelsByFacilities(String facilities);
    //ArrayList<Accommodation> getHotelsByPrice(String maxPrice);
    ArrayList<Accommodation> getHotelsByName(String name);

}


package controllers;

import entities.Accommodation;
import entities.Room;
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


    public ArrayList<Room> filterByPrice(Accommodation accommodation, double maxPrice) {
        ArrayList<Room> result = new ArrayList<>();

        for (Room room : accommodation.getAllRooms()) {
            if(room.getPrice()<=maxPrice) {
                result.add(room);
            }
        }
        return result;
    }

    public ArrayList<Accommodation> findByName(String name) {
        return data.getHotelsByName(name);
    }

    public ArrayList<Accommodation> findByTimePeriod(Date from, Date to) {
        return data.getHotelsByTimePeriod(from, to);
    }

    // endurrada args
    /**
     *
     * Fall sem leitar að gistingu eftir ákveðnum skilyrðum. Sjá nánar fyrir hvern og einn param ef á bara að taka tillit
     *      til sumra þeirra.
     * @param location String, tómi strengurinn ef á ekki að taka tillit til
     * @param minRating double, <=0.0 ef á ekki að taka tillit til
     * @param maxPrice double, Double.POSITIVE_INFINITY ef á ekki að taka tillit til
     * @param name String, tómi strengurinn ef á ekki að taka tillit til
     * @return ArrayList<Accommodation>, result úr leit. Ath. að Accommodations innihalda method
     *      getAvailableRooms(Date from, Date to) svo það sér um að vita availability
     */
    public ArrayList<Accommodation> search(String location, double minRating,
                                                         String name) {

        // init
        ArrayList<Accommodation> theResult = new ArrayList<>(data.getAllHotels());

        ArrayList<Accommodation> nameResult = findByName(name);
        ArrayList<Accommodation> locationResult = findByLocation(location);
        ArrayList<Accommodation> ratingResult = findByRating(minRating);

        System.out.println(ratingResult);
        // finnum sniðmengi af þeim results úr queries sem innihalda ekki tóma strenginn (eða null í Date)
        // munum alltaf nota minRating og maxPrice, g.r.f. 0 og inf default gildum ef ekki á að leita eftir því
        theResult.retainAll(ratingResult);

        if(!location.equals("")) {
            System.out.println("location");
            theResult.retainAll(locationResult);
        }
        if(!name.equals("")) {
            System.out.println("name");
            theResult.retainAll(nameResult);
        }

        return theResult;
    }

    public static void main(String[] args) {

    }
}

package controllers;

import entities.Accommodation;
import storage.Database;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

import static java.util.Objects.isNull;


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

    // kannski beila bara á find by facilities...
    public ArrayList<Accommodation> findByFacilities(String facilities) {
        return new ArrayList<>();
    }

    public ArrayList<Accommodation> findByPrice(double maxPrice) {
        return data.getHotelsByPrice(maxPrice);
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
     * @param facilities no idea
     * @param maxPrice double, Double.POSITIVE_INFINITY ef á ekki að taka tillit til
     * @param name String, tómi strengurinn ef á ekki að taka tillit til
     * @param from Date, null ef ekki á að taka tillit til.
     * @param to Date, null ef ekki á að taka tillit til.
     * @return ArrayList<Accommodation>, result úr leit.
     */
    public ArrayList<Accommodation> search(String location, double minRating, String facilities, double maxPrice,
                                                         String name, Date from, Date to) {

        // init
        ArrayList<Accommodation> theResult = new ArrayList<>(data.getAllHotels());

        ArrayList<Accommodation> nameResult = findByName(name);
        ArrayList<Accommodation> locationResult = findByLocation(location);
        ArrayList<Accommodation> facilitiesResult = findByFacilities(facilities);
        ArrayList<Accommodation> ratingResult = findByRating(minRating);
        ArrayList<Accommodation> priceResult = findByPrice(maxPrice);
        ArrayList<Accommodation> periodResult = findByTimePeriod(from, to);


        // finnum sniðmengi af þeim results úr queries sem innihalda ekki tóma strenginn (eða null í Date)
        // munum alltaf nota minRating og maxPrice, g.r.f. 0 og inf default gildum ef ekki á að leita eftir því
        theResult.retainAll(ratingResult);
        theResult.retainAll(priceResult);
        if(!location.equals("")) {
            System.out.println("location");
            theResult.retainAll(locationResult);
        }
        if(!isNull(from) && !isNull(to)) {
            System.out.println("date");
            theResult.retainAll(periodResult);
        }
        if(!facilities.equals("")) {
            System.out.println("facilities");
            theResult.retainAll(facilitiesResult);
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

package storage;

import entities.Accommodation;

import java.util.ArrayList;

public class AllHotelsMock implements Database {
    // láta DataFactory skila röðum eins og database myndi gera?
    private DataFactory fakeData = new DataFactory();
    ArrayList<Accommodation> allHotels = fakeData.getAccommodationsSmallConstructor();
    @Override
    public ArrayList<Accommodation> getAllHotels(String q) {
        ArrayList<Accommodation> allHotels = fakeData.getAccommodationsSmallConstructor();
        return allHotels;
    }
    @Override
    public ArrayList<Accommodation> getHotelsByLocation(String location) {
        return allHotels;
    }
}
// database implementation og mockimplementation
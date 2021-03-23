package storage;

import entities.Accommodation;

import java.util.ArrayList;

public class AllHotelsMock implements Database {
    // láta DataFactory skila röðum eins og database myndi gera?
    private DataFactory fakeData = new DataFactory();
    ArrayList<Accommodation> allHotels = fakeData.getAccommodationsSmallConstructor();
    @Override
    public ArrayList<Accommodation> query(String q) {
        ArrayList<Accommodation> allHotels = fakeData.getAccommodationsSmallConstructor();
        return allHotels;
    }
}

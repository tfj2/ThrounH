package storage;

import entities.Accommodation;

import java.util.ArrayList;

public class AllHotelsMock implements DatabaseService {
    private DataFactory fakeData = new DataFactory();
    ArrayList<Accommodation> allHotels = fakeData.getAccommodationsSmallConstructor();
    @Override
    public ArrayList<Accommodation> query(String q) {
        ArrayList<Accommodation> allHotels = fakeData.getAccommodationsSmallConstructor();
        return allHotels;
    }
}

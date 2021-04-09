package storage;

import entities.Accommodation;
import entities.Room;
import entities.RoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.util.ArrayList;

public class DataFactory implements Database {
    public DataFactory() {
    }

    public ArrayList<Accommodation> getAllHotels() {
        ArrayList<Accommodation> accommodations = new ArrayList<>();
        ArrayList<Room> rooms = getRooms();
        ArrayList<String> managerIds = new ArrayList<>();
        managerIds.add("1");
        managerIds.add("2");
        Accommodation acc1 = new Accommodation("1","Hilton", "Reykjavik", rooms, managerIds);
        Accommodation acc2 = new Accommodation("2","Kea", "Akureyri", rooms, managerIds);
        Accommodation acc3 = new Accommodation("3","Hotel Selfoss", "Selfoss", rooms, managerIds);
        Accommodation acc4 = new Accommodation("4","Grand", "Reykjavik", rooms, managerIds);
        Accommodation acc5 = new Accommodation("5","Kjarnalundur", "Akureyri", rooms, managerIds);
        Accommodation acc6 = new Accommodation("6","Hotel Cabin", "Reykjavik", rooms, managerIds);
        Accommodation acc7 = new Accommodation("7","Nordica", "Reykjavik", rooms, managerIds);
        Accommodation acc8 = new Accommodation("8","Midgardur", "Reykjavik", rooms, managerIds);
        Accommodation acc9 = new Accommodation("9","201 Hotel", "Reykjavik", rooms, managerIds);
        Accommodation acc10 = new Accommodation("10","Alda", "Reykjavik", rooms, managerIds);
        accommodations.add(acc1);
        accommodations.add(acc2);
        accommodations.add(acc3);
        accommodations.add(acc4);
        accommodations.add(acc5);
        accommodations.add(acc6);
        accommodations.add(acc7);
        accommodations.add(acc8);
        accommodations.add(acc9);
        accommodations.add(acc10);
        return accommodations;
    }

    public ArrayList<Accommodation> getHotelsByLocation(String location) {
        System.out.println("bara til að vera legal");
        return new ArrayList<Accommodation>();
    }

    @Override
    public ArrayList<Accommodation> getHotelsByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Accommodation> getHotelsByRating(double minRating) {
        return null;
    }

    @Override
    public ArrayList<Accommodation> getHotelsByPrice(double maxPrice) {
        return null;
    }

    @Override
    public ArrayList<Accommodation> getHotelsByTimePeriod(Date from, Date to) {
        return new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("1", 10000, RoomType.Single, 1));
        rooms.add(new Room("2", 10000, RoomType.Single, 1));
        rooms.add(new Room("3", 13000, RoomType.Double, 2));
        rooms.add(new Room("4", 15000, RoomType.Triple, 3));
        rooms.add(new Room("5", 16000, RoomType.Studio, 6));
        rooms.add(new Room("6", 14000, RoomType.Twin, 3));
        rooms.add(new Room("7", 16000, RoomType.Quad, 5));
        rooms.add(new Room("8", 11000, RoomType.Queen, 3));
        rooms.add(new Room("9", 14000, RoomType.King, 3));
        return rooms;
    }
}

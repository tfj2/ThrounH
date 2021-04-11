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
        ArrayList<String> managerIds = new ArrayList<>();
        managerIds.add("1");
        managerIds.add("2");
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("1", 10000, RoomType.Single, 1));
        rooms.add(new Room("2", 10000, RoomType.Single, 1));
        Accommodation acc1 = new Accommodation("1","Hilton", "Reykjavik", rooms, managerIds, 5.0);
        ArrayList<Room> rooms2 = new ArrayList<>();
        rooms2.add(new Room("3", 13000, RoomType.Double, 2));
        rooms2.add(new Room("4", 15000, RoomType.Triple, 3));
        Accommodation acc2 = new Accommodation("2","Kea", "Akureyri", rooms2, managerIds, 2.5);
        ArrayList<Room> rooms3 = new ArrayList<>();
        rooms3.add(new Room("5", 130, RoomType.Twin, 2));
        rooms3.add(new Room("6", 13243, RoomType.Quad, 4));
        Accommodation acc3 = new Accommodation("3","Hotel Selfoss", "Selfoss", rooms3, managerIds, 3.9);
        ArrayList<Room> rooms4 = new ArrayList<>();
        rooms4.add(new Room("7", 13000, RoomType.King, 5));
        rooms4.add(new Room("8", 15000, RoomType.Queen, 3));
        rooms4.add(new Room("21", 13000, RoomType.King, 5));
        rooms4.add(new Room("22", 15000, RoomType.Queen, 3));
        Accommodation acc4 = new Accommodation("4","Grand", "Reykjavik", rooms4, managerIds, 4.6);
        ArrayList<Room> rooms5 = new ArrayList<>();
        rooms5.add(new Room("9", 200, RoomType.Studio, 1));
        rooms5.add(new Room("10", 13232, RoomType.Triple, 3));
        Accommodation acc5 = new Accommodation("5","Kjarnalundur", "Akureyri", rooms5, managerIds, 0.1);
        ArrayList<Room> rooms6 = new ArrayList<>();
        rooms6.add(new Room("11", 1303400, RoomType.Single, 2));
        rooms6.add(new Room("12", 150005, RoomType.King, 3));
        Accommodation acc6 = new Accommodation("6","Hotel Cabin", "Reykjavik", rooms6, managerIds, 0.6);
        ArrayList<Room> rooms7 = new ArrayList<>();
        rooms7.add(new Room("13", 13000, RoomType.Double, 2));
        rooms7.add(new Room("14", 123400, RoomType.Studio, 3));
        Accommodation acc7 = new Accommodation("7","Nordica", "Reykjavik", rooms7, managerIds, 4.8);
        ArrayList<Room> rooms8 = new ArrayList<>();
        rooms8.add(new Room("15", 130500, RoomType.Double, 2));
        rooms8.add(new Room("16", 150300, RoomType.Triple, 3));
        Accommodation acc8 = new Accommodation("8","Midgardur", "Reykjavik", rooms8, managerIds, 2.8);
        ArrayList<Room> rooms9 = new ArrayList<>();
        rooms9.add(new Room("17", 100, RoomType.Single, 1));
        rooms9.add(new Room("18", 100, RoomType.Single, 1));
        Accommodation acc9 = new Accommodation("9","201 Hotel", "Reykjavik", rooms9, managerIds, 4.6);
        ArrayList<Room> rooms10 = new ArrayList<>();
        rooms10.add(new Room("19", 1300, RoomType.Double, 2));
        rooms10.add(new Room("20", 150500, RoomType.Triple, 3));
        Accommodation acc10 = new Accommodation("10","Alda", "Reykjavik", rooms10, managerIds, 4.3);
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
}

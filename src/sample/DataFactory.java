package sample;

import entities.Accommodation;
import entities.Room;
import entities.RoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DataFactory {
    public DataFactory() {
    }

    public ObservableList<Accommodation> getAccommodations() {
        ObservableList<Accommodation> accommodations = FXCollections.observableArrayList();
        ArrayList<Room> rooms = getRooms();
        ArrayList<String> managerIds = new ArrayList<>();
        managerIds.add("1");
        managerIds.add("2");

        Accommodation acc1 = new Accommodation("1","Hilton", "Reykjavik", rooms, managerIds);
        Accommodation acc2 = new Accommodation("2","Kea", "Akureyri", rooms, managerIds);
        Accommodation acc3 = new Accommodation("3","Hotel Selfoss", "Selfoss", rooms, managerIds);
        Accommodation acc4 = new Accommodation("4","Grand", "Reykjavik", rooms, managerIds);
        Accommodation acc5 = new Accommodation("5","Kjarnalundur", "Akureyri", rooms, managerIds);

        accommodations.add(acc1);
        accommodations.add(acc2);
        accommodations.add(acc3);
        accommodations.add(acc4);
        accommodations.add(acc5);
        return accommodations;
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

package entities;

import java.util.ArrayList;

public class Room {
    private String roomId;
    private RoomType roomType;
    private double price;
    private int cap;
    private ArrayList<Occupancy> occupancies;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public Room(String roomId, double price, RoomType roomType, int cap) {
        this.roomId = roomId;
        this.price = price;
        this.cap = cap;
        this.roomType = roomType;
        occupancies = new ArrayList<>();
    }
    public void addOccupancy(Occupancy occupancy) {
        occupancies.add(occupancy);
    }

    public ArrayList<Occupancy> getOccupancies() {
        return occupancies;
    }

    public String toString() {
        return roomType.toString();
    }
}
//siggigauti/video-leiga-support

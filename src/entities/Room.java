package entities;

enum RoomType {
    Single, Double, Triple, Quad, Queen, King, Twin, Studio;
}

public class Room {
    private String roomId;
    private RoomType roomType;
    private double price;
    private int cap;

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
    }
}

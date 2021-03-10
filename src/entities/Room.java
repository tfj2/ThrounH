package entities;

<<<<<<<HEAD
//Setti inn enum, held að það virki svona, stórir stafir því double má ekki vera með litlum

=======

enum RoomType {
    Single, Double, Triple, Quad, Queen, King, Twin, Studio;
}
>>>>>>>da80c62ce15f757d9f3483efb7f883487f63a46c

public class Room {
    private String roomId;

    private RoomType roomType;

    private double price;
    private int cap;

    //public enum getRoomType() {
    //    return roomType;
    //}
    /*
    public enum setRoomType(enum roomType) {
        this.roomType =roomType;
    }
     */

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

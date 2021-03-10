package entities;

import entities.Room.roomType;

//Setti inn enum, held að það virki svona, stórir stafir því double má ekki vera með litlum
enum roomType {
    Single, Double, Triple, Quad, Queen, King, Twin, Double-Double,Studio;
}

public class Room {
    private String roomId;

    private enum roomType

    ;
    private double price;
    private int cap;

    public Room(String roomId, double price, enum roomType, int cap) {
        this.roomId = roomId;
        this.price = price;
        this.cap = cap;
        this.roomType = roomType
    }

    public enum getRoomType() {
        return roomType;
    }

    public enum setRoomType(enum roomType) {
        this.roomType =roomType;
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


}

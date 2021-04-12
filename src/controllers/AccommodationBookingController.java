package controllers;

import entities.Booking;
import entities.Occupancy;

public class AccommodationBookingController {
    public AccommodationBookingController() {

    }

    public void addBooking(Booking booking){
        Occupancy occupancy = new Occupancy(booking.getBookingDateFrom(), booking.getBookingDateTo());
        booking.getRoom().addOccupancy(occupancy);
        System.out.println("Room booked");
    }

    public void removeBooking(Booking booking){

    }

    public void changeBooking(Booking booking){

    }
}

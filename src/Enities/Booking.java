package Enities;

public class Booking {
    private User user;  //vonandi virkar thetta
    private ArrayList<String> guests; //Eigum við að hafa þetta sem arraylist?
    private Accommodation accommodation;
    private Room room;
    private String id;
    private String bookingDateFromTo; //Hvernig ætlum við að geyma þetta?

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<String> guests) {
        this.guests = guests;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingDateFromTo() {
        return bookingDateFromTo;
    }

    public void setBookingDateFromTo(String bookingDateFromTo) {
        this.bookingDateFromTo = bookingDateFromTo;
    }

    public Booking(User user, ArrayList<String> guests, Accommodation accommodation, Room room, String id, String bookingDateFromTo) {
        this.user = user;
        this.guests = guests;
        this.accommodation = accommodation;
        this.room = room;
        this.id = id;
        this.bookingDateFromTo = bookingDateFromTo;
    }
}

package storage;

import entities.Accommodation;

import java.util.ArrayList;

public interface Database {
    // if query empty return all ætti að vera thing
    // ætti örugglega að skila ehv skonar Result obj ?
    ArrayList<Accommodation> query(String query);
}


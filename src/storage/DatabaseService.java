package storage;

import entities.Accommodation;

import java.util.ArrayList;

public interface DatabaseService {
    // if query empty return all ætti að vera thing
    ArrayList<Accommodation> query(String query);
}


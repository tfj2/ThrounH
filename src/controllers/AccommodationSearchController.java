package controllers;

import entities.Accommodation;
import storage.AllHotelsMock;
import storage.Database;

import java.sql.Date;
import java.util.ArrayList;



public class AccommodationSearchController {
    private Database data;
    private ArrayList<Accommodation>  accommodations;

    public AccommodationSearchController(Database data) {
        this.data = data;
    }

    public ArrayList<Accommodation> findByLocation(String query) {
        // hér er ekki verið að gera ráð fyrir því að fá raðir úr sql query sbr. sequence diagram.
        // hér væri kannski loop til að bua til Accommodation obj úr niðurstöðum gagnagrunns


        ArrayList<Accommodation> result = new ArrayList<>();

        // kannski reduntant loopa ef við látum sql sjá um leitina ?
        for (Accommodation acc : accommodations) {
            // contains er case sensitive, gerum leitina það ekki
            if(acc.getLocation().toLowerCase().contains(query.toLowerCase())) {
                result.add(acc);
            }
        }
        return result;
    }

    public ArrayList<Accommodation> findByRating(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByFacilities(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByPrice(String query) {
        return null;
    }

    public ArrayList<Accommodation> findByName(String query) {
        ArrayList<Accommodation> result = new ArrayList<>();
        for (Accommodation acc : accommodations) {
            if(acc.getLocation().contains(query)) {
                result.add(acc);
            }
        }
        return result;
    }

    public ArrayList<Accommodation> findByTimePeriod(Date from, Date to) {
        return null;
    }
    public static void main(String[] args) {

    }

}

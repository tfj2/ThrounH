package test.controllers;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import entities.Room;
import entities.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import storage.DatabaseMockEmptyQuery;
import storage.DatabaseMockNonEmptyQuery;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class AccommodationSearchControllerTest {
    AccommodationSearchController sc;
    AccommodationSearchController sce;
    ArrayList<Accommodation> mockData = new ArrayList<>();
    Accommodation acc1;
    Accommodation acc2;
    Accommodation acc3;
    Accommodation acc4;

    @Before
    public void setUp() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("1", 10000, RoomType.Single, 1));

        ArrayList<String> managerIds = new ArrayList<>();
        managerIds.add("1");
        managerIds.add("2");

        acc1 = new Accommodation("1", "Hilton", "Reykjavik", rooms, managerIds);
        acc2 = new Accommodation("2", "Kea", "Akureyri", rooms, managerIds);
        acc3 = new Accommodation("3", "Hotel Selfoss", "Selfoss", rooms, managerIds);
        acc4 = new Accommodation("4", "Grand Hotel", "Reykjavik", rooms, managerIds);

        mockData.add(acc1);
        mockData.add(acc2);
        mockData.add(acc3);
        mockData.add(acc4);

        sc = new AccommodationSearchController(new DatabaseMockNonEmptyQuery(mockData));
        sce = new AccommodationSearchController(new DatabaseMockEmptyQuery(mockData));
    }

    @After
    public void tearDown() {
        // þurfum ekki
    }

    @Test
    public void testFindByLocationEmptySearch() {
        assertNull(sce.findByLocation(""));
    }

    @Test
    public void testFindByLocationSubSearch() {
        assertEquals(sce.findByLocation("rey"), sce.findByLocation("reykjavik"));
    }

    @Test
    public void testFindByLocationCaseInsensitive() {
        assertEquals(sc.findByLocation("rEykjavik"), sc.findByLocation("Reykjavik"));

    }

    @Test
    public void testFindByNameEmptySearch() {
        assertNull(sce.findByName(""));
    }

    @Test
    public void testFindByNameSubSearch() {
        assertEquals(sce.findByName("hot"), sce.findByName("hotel"));
    }

    @Test
    public void testFindByNameCaseInsensitive() {
        assertEquals(sc.findByName("hoTel"), sc.findByName("Hotel"));
    }

    @Test
    public void testFindByRating() {
        ArrayList<Accommodation> result1 = sc.findByRating(-1);
        ArrayList<Accommodation> result2 = sc.findByRating(0);
        ArrayList<Accommodation> result3 = sc.findByRating(1);

        ArrayList<Accommodation> expected1 = mockData;
        ArrayList<Accommodation> expected2 = mockData;
        ArrayList<Accommodation> expected3 = new ArrayList<>();

        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
    }

    @Test
    public void testFindByNameAndLocation() {
        ArrayList<Accommodation> byName = sc.findByName("Hotel");
        ArrayList<Accommodation> byLocation = sc.findByLocation("Reykjavik");
        // sniðmengi.
        byName.retainAll(byLocation);

        assertEquals(byName.get(0), acc4);
    }

    // Ef sniðmengi er að stærð 0.
    @Test
    public void testFindByNameAndRating() {
        ArrayList<Accommodation> byName = sc.findByName("kea");
        ArrayList<Accommodation> byLocation = sc.findByLocation("Selfoss");

        byName.retainAll(byLocation);

        assertNotNull(byName);
        assertEquals(byName.size(), 0);
    }

    //10 til 13 test cases fyrir um það bil 3 föll
}

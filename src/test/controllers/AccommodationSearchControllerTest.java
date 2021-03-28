package test.controllers;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import entities.Room;
import entities.RoomType;
import org.junit.*;
import storage.DatabaseMockEmptyQuery;
import storage.DatabaseMockNonEmptyQuery;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class AccommodationSearchControllerTest {
    AccommodationSearchController sc;
    AccommodationSearchController sce;
    @Before
    public void setUp() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("1", 10000, RoomType.Single, 1));

        ArrayList<Accommodation> mockData = new ArrayList<>();

        ArrayList<String> managerIds = new ArrayList<>();
        managerIds.add("1");
        managerIds.add("2");

        Accommodation acc1 = new Accommodation("1","Hilton", "Reykjavik", rooms, managerIds);
        Accommodation acc2 = new Accommodation("2","Kea", "Akureyri", rooms, managerIds);
        Accommodation acc3 = new Accommodation("3","Hotel Selfoss", "Selfoss", rooms, managerIds);
        Accommodation acc4 = new Accommodation("4","Grand Hotel", "Reykjavik", rooms, managerIds);

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

    }

    @Test
    public void testFindByNameCaseInsensitive() {
        assertEquals(sc.findByName("hoTel"), sc.findByName("Hotel"));
    }

    @Test
    public void testFindByRating() {

    }

    @Test
    public void testFindByNameAndLocation() {

    }





    //10 til 13 test cases fyrir um það bil 3 föll
}
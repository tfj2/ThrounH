package test.controllers;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import entities.Room;
import entities.RoomType;
import org.junit.*;
import storage.DatabaseMockEmpty;
import storage.DatabaseMock;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class AccommodationSearchControllerTest {
    AccommodationSearchController sc;

    ArrayList<Accommodation> mockData = new ArrayList<>();
    ArrayList<Accommodation> empty = new ArrayList<>();
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

        acc1 = new Accommodation("1","Hilton", "Reykjavik", rooms, managerIds);
        acc2 = new Accommodation("2","Kea", "Akureyri", rooms, managerIds);
        acc3 = new Accommodation("3","Hotel Selfoss", "Selfoss", rooms, managerIds);
        acc4 = new Accommodation("4","Grand Hotel", "Reykjavik", rooms, managerIds);

        mockData.add(acc1);
        mockData.add(acc2);
        mockData.add(acc3);
        mockData.add(acc4);

        sc = new AccommodationSearchController(new DatabaseMock(mockData));
    }
    @After
    public void tearDown() {
        // þurfum ekki
    }
    @Test
    public void testFindByLocationEmptySearch() {
        assertEquals(empty, sc.findByLocation(""));
    }

    @Test
    public void testFindByLocationSubSearch() {
        assertEquals(sc.findByLocation("reykj"), sc.findByLocation("reykjavik"));
    }

    @Test
    public void testFindByLocationCaseInsensitive() {
        assertEquals(sc.findByLocation("rEykjavik"), sc.findByLocation("Reykjavik"));

    }

    @Test
    public void testFindByNameEmptySearch() {
        assertEquals(empty, sc.findByName(""));
    }

    @Test
    public void testFindByNameSubSearch() {
        assertEquals(sc.findByName("hot"), sc.findByName("hotel"));
    }

    @Test
    public void testFindByNameCaseInsensitive() {
        assertEquals(sc.findByName("hoTel"), sc.findByName("Hotel"));
    }

    @Test
    public void testFindByRating() {
        ArrayList<Accommodation> result1 = sc.findByRating(0);
        ArrayList<Accommodation> result2 = sc.findByRating(1);

        // g.r.f. að allir hafa 0 í rating
        ArrayList<Accommodation> expected1 = mockData;
        ArrayList<Accommodation> expected2 = new ArrayList<>();

        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
    }

    @Test
    public void testFindByRatingNegative() {
        ArrayList<Accommodation> result1 = sc.findByRating(-1);
        // db mun breyta neikvæðum tölum í 0 áður en leit hefst, og mundi þá skila öllum
        assertEquals(result1, mockData);
    }

    @Test
    public void testFindByMultiple() {
        ArrayList<Accommodation> byName = sc.findByName("Hotel");
        ArrayList<Accommodation> byLocation = sc.findByLocation("Reykjavik");
        // sniðmengi.
        byName.retainAll(byLocation);

        assertEquals(byName.get(0), acc4);
    }

    //10 til 13 test cases fyrir um það bil 3 föll
}
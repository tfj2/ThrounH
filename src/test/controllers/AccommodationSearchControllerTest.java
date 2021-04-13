package test.controllers;

import controllers.AccommodationSearchController;
import entities.Accommodation;
import entities.Room;
import entities.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import storage.DatabaseMock;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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

        acc1 = new Accommodation("1", "Hilton", "Reykjavik", rooms, managerIds, 0.1);
        acc2 = new Accommodation("2", "Kea", "Akureyri", rooms, managerIds, 0.5);
        acc3 = new Accommodation("3", "Hotel Selfoss", "Selfoss", rooms, managerIds, 3.5);
        acc4 = new Accommodation("4", "Grand Hotel", "Reykjavik", rooms, managerIds,5.0);

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
    public void testFindByNameAndLocation() {
        ArrayList<Accommodation> byName = sc.findByName("Hotel");
        ArrayList<Accommodation> byLocation = sc.findByLocation("Reykjavik");
        // sniðmengi.
        byName.retainAll(byLocation);

        assertEquals(byName.get(0), acc4);
    }

    @Test
    public void testFindByNameAndLocationNoResults() {
        ArrayList<Accommodation> byName = sc.findByName("kea");
        ArrayList<Accommodation> byLocation = sc.findByLocation("Selfoss");

        byName.retainAll(byLocation);

        // Ef sniðmengi er að stærð 0.
        assertNotNull(byName);
        assertEquals(byName.size(), 0);
    }

    @Test
    public void testCombinedSearch() {
        ArrayList<Accommodation> byName = sc.findByName("kea");
        ArrayList<Accommodation> byCombined = sc.search("", 0.0, "kea");
        assertEquals(byName, byCombined);
    }
}

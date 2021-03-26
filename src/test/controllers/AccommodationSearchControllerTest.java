package test.controllers;

import controllers.AccommodationSearchController;
import org.junit.*;
import storage.AllHotelsMock;

import static org.junit.Assert.*;


public class AccommodationSearchControllerTest {
    AccommodationSearchController sc;
    @Before
    public void setUp() {
        sc = new AccommodationSearchController(new AllHotelsMock());
    }
    @After
    public void tearDown() {

    }
    @Test
    public void testFindByLocationEmptySearch() {

    }
    @Test
    public void testFindByLocationSubSearch() {

    }
    @Test
    public void testFindByLocationCaseInsensitive() {

    }
    //10 til 13 föll
}
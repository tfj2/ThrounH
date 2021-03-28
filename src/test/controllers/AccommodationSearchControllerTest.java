package test.controllers;

import controllers.AccommodationSearchController;
import org.junit.*;
import storage.DatabaseMockEmptyQuery;
import storage.DatabaseMockNonEmptyQuery;

import static org.junit.Assert.assertEquals;


public class AccommodationSearchControllerTest {
    AccommodationSearchController sc;
    AccommodationSearchController sce;
    @Before
    public void setUp() {

        sc = new AccommodationSearchController(new DatabaseMockNonEmptyQuery());
        sce = new AccommodationSearchController(new DatabaseMockEmptyQuery());
    }
    @After
    public void tearDown() {
        // þurfum ekki
    }
    @Test
    public void testFindByLocationEmptySearch() {
        assertEquals(null, sce.findByLocation(""));
    }

    @Test
    public void testFindByLocationSubSearch() {

    }

    @Test
    public void testFindByLocationCaseInsensitive() {
        assertEquals(sc.findByLocation("rEykjavik"), sc.findByLocation("Reykjavik"));

    }


    //10 til 13 test cases fyrir um það bil 3 föll
}
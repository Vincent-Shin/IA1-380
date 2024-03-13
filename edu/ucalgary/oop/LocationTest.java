package edu.ucalgary.oop;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LocationTest {

    // Define test data
    private String testName = "Shelter A";
    private String testAddress = "123 Main St";
    private DisasterVictim testOccupant = new DisasterVictim("John", "2024-03-15");
    private Supply testSupply = new Supply("Water Bottle", 10);

    // Test the constructor and getters
    @Test
    public void testConstructorAndGetters() {
        Location location = new Location(testName, testAddress);
        assertEquals("getName() should return the correct name", testName, location.getName());
        assertEquals("getAddress() should return the correct address", testAddress, location.getAddress());
        assertTrue("getOccupants() should return an empty list initially", location.getOccupants().isEmpty());
        assertTrue("getSupplies() should return an empty list initially", location.getSupplies().isEmpty());
    }

    // Test the setters for occupants and supplies
    @Test
    public void testSetters() {
        Location location = new Location(testName, testAddress);

        ArrayList<DisasterVictim> testOccupantsList = new ArrayList<>();
        testOccupantsList.add(testOccupant);
        location.setOccupants(testOccupantsList);
        assertEquals("setOccupants() should correctly set the occupants list", testOccupantsList, location.getOccupants());

        ArrayList<Supply> testSuppliesList = new ArrayList<>();
        testSuppliesList.add(testSupply);
        location.setSupplies(testSuppliesList);
        assertEquals("setSupplies() should correctly set the supplies list", testSuppliesList, location.getSupplies());
    }

    // Test the addOccupant() and removeOccupant() methods
    @Test
    public void testAddAndRemoveOccupant() {
        Location location = new Location(testName, testAddress);
        location.addOccupant(testOccupant);
        assertTrue("addOccupant() should add the occupant to the location", location.getOccupants().contains(testOccupant));
        location.removeOccupant(testOccupant);
        assertFalse("removeOccupant() should remove the occupant from the location", location.getOccupants().contains(testOccupant));
    }

    // Test the addSupply() and removeSupply() methods
    @Test
    public void testAddAndRemoveSupply() {
        Location location = new Location(testName, testAddress);
        location.addSupply(testSupply);
        assertTrue("addSupply() should add the supply to the location", location.getSupplies().contains(testSupply));
        location.removeSupply(testSupply);
        assertFalse("removeSupply() should remove the supply from the location", location.getSupplies().contains(testSupply));
    }
}


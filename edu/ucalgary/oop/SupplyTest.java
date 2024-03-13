package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SupplyTest {
    private Supply supply;
    private String expectedType = "Food";
    private int expectedQuantity = 100;

    @Before
    public void setUp() {
        supply = new Supply(expectedType, expectedQuantity);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Supply object should not be null", supply);
    }

    @Test
    public void testGetType() {
        assertEquals("Type should match the one set in setup", expectedType, supply.getType());
    }

    @Test
    public void testGetQuantity() {
        assertEquals("Quantity should match the one set in setup", expectedQuantity, supply.getQuantity());
    }

    @Test
    public void testSetType() {
        String newType = "Water";
        supply.setType(newType);
        assertEquals("Type should be updated", newType, supply.getType());
    }

    @Test
    public void testSetQuantity() {
        int newQuantity = 50;
        supply.setQuantity(newQuantity);
        assertEquals("Quantity should be updated", newQuantity, supply.getQuantity());
    }
}


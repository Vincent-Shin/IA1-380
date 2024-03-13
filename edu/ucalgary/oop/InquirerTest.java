package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Test;

public class InquirerTest {

    // Define the expected values for testing
    private String expectedFirstName = "Joseph";
    private String expectedLastName = "Bouillon";
    private String expectedPhoneNumber = "+1-123-456-7890";
    private String expectedMessage = "looking for my family members";

    private Inquirer inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedMessage);

    // Test whether the Inquirer object is successfully created
    @Test
    public void testObjectCreation() {
        assertNotNull("Inquirer object should not be null", inquirer);
    }

    // Test the getFirstName() method
    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return correct first name", expectedFirstName, inquirer.getFirstName());
    }

    // Test the getLastName() method
    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return correct last name", expectedLastName, inquirer.getLastName());
    }

    // Test the getServicesPhoneNum() method
    @Test
    public void testGetServicesPhoneNum() {
        assertEquals("getServicesPhoneNum() should return correct phone number", expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }

    // Test the getInfo() method
    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return correct message", expectedMessage, inquirer.getInfo());
    }
}


/*
Copyright [Your Name], [Year]
Licensed under [License], see [LICENSE.txt]
*/

package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String validDate = "2024-03-15";
    private String invalidDate = "2024/03/15";
    private String expectedInfoProvided = "Requesting emergency assistance";
    private String expectedLogDetails = "Inquirer: Alice, Missing Person: Bob, Date of Inquiry: 2024-03-15, Info Provided: Requesting emergency assistance, Last Known Location: Red Cross Shelter";

    @Before
    public void setUp() {
        inquirer = new Inquirer("Alice", "Smith", "+1-123-456-7890", "Requesting emergency assistance");
        missingPerson = new DisasterVictim("Bob", "2024-01-01");
        lastKnownLocation = new Location("Red Cross Shelter", "123 Main St");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", inquirer, reliefService.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", missingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testGetDateOfInquiry() {
        assertEquals("Date of inquiry should match the one set in setup", validDate, reliefService.getDateOfInquiry());
    }

    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided should match the one set in setup", expectedInfoProvided, reliefService.getInfoProvided());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", lastKnownLocation, reliefService.getLastKnownLocation());
    }

    @Test
    public void testSetDateOfInquiryWithValidDate() {
        reliefService.setDateOfInquiry(validDate);
        assertEquals("Setting a valid date should update the date of inquiry", validDate, reliefService.getDateOfInquiry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        reliefService.setDateOfInquiry(invalidDate); // This should throw IllegalArgumentException due to invalid format
    }

    @Test
    public void testGetLogDetails() {
        assertEquals("Log details should match the expected format", expectedLogDetails, reliefService.getLogDetails());
    }
}



package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person person;
    private String firstName = "John";
    private String lastName = "Doe";
    private String validDate = "2000-01-01";
    private String invalidDate = "01/01/2000";
    private String validGender = "male";
    private String invalidGender = "unknown";
    private String entryDate = "2024-03-15";

    @Before
    public void setUp() {
        person = new PersonMock(firstName, lastName, entryDate);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Person object should not be null", person);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("First name should match the one set in setup", firstName, person.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Last name should match the one set in setup", lastName, person.getLastName());
    }

    @Test
    public void testSetDateOfBirthWithValidDate() {
        person.setDateOfBirth(validDate);
        assertEquals("Date of birth should be updated", validDate, person.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidDate() {
        person.setDateOfBirth(invalidDate);
    }

    @Test
    public void testSetGenderWithValidGender() {
        person.setGender(validGender);
        assertEquals("Gender should be updated", validGender, person.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetGenderWithInvalidGender() {
        person.setGender(invalidGender);
    }

    @Test
    public void testSetComments() {
        String comments = "This is a test comment";
        person.setComments(comments);
        assertEquals("Comments should be updated", comments, person.getComments());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("Entry date should match the one set in setup", entryDate, person.getEntryDate());
    }

    // Mock class to test the abstract Person class
    private class PersonMock extends Person {
        public PersonMock(String firstName, String lastName, String entryDate) {
            super(firstName, lastName, entryDate);
        }
    }
}


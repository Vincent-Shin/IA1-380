package edu.ucalgary.oop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private List<Supply> suppliesToSet;
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
    }

    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }

    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        FamilyRelation[] expectedRelations = {relation};
        victim2.setFamilyConnections(expectedRelations);

        FamilyRelation[] testFamily = victim2.getFamilyConnections();
        assertTrue("addFamilyConnection should add a family relationship", testFamily.length == 1 && testFamily[0] == expectedRelations[0]);
    }

    @Test
    public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);
        FamilyRelation[] originalRelations = {relation1, relation2};
        victim.setFamilyConnections(originalRelations);

        victim.removeFamilyConnection(relation1);

        FamilyRelation[] testFamily = victim.getFamilyConnections();
        assertTrue("removeFamilyConnection should remove the family member", testFamily.length == 1 && testFamily[0] == relation2);
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        Supply[] testSupplies = victim.getPersonalBelongings();
        assertTrue("addPersonalBelonging should add the supply to personal belongings", testSupplies.length == 1 && testSupplies[0] == newSupply);
    }

    @Test
    public void testRemovePersonalBelonging() {
        Supply supplyToRemove = suppliesToSet.get(0);
        victim.addPersonalBelonging(supplyToRemove);
        victim.removePersonalBelonging(supplyToRemove);

        Supply[] testSupplies = victim.getPersonalBelongings();
        assertTrue("removePersonalBelonging should remove the supply from personal belongings", testSupplies.length == 0);
    }

    @Test
    public void testSetPersonalBelongings() {
        Supply one = new Supply("Tent", 1);
        Supply two = new Supply("Jug", 3);
        Supply[] newSupplies = {one, two};

        victim.setPersonalBelongings(newSupplies);
        Supply[] actualSupplies = victim.getPersonalBelongings();

        assertArrayEquals("setPersonalBelongings should correctly update personal belongings", newSupplies, actualSupplies);
    }

    @Test
    public void testSetAndGetFamilyConnections() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        FamilyRelation[] expectedRelations = {relation};
        victim1.setFamilyConnections(expectedRelations);

        FamilyRelation[] actualRelations = victim1.getFamilyConnections();
        assertArrayEquals("getFamilyConnections should return the correct family relations", expectedRelations, actualRelations);
    }

    @Test
    public void testAddDietaryRestriction() {
        victim.addDietaryRestriction(DietaryRestriction.AVML);
        assertTrue("addDietaryRestriction should add a dietary restriction", victim.getDietaryRestrictions().contains(DietaryRestriction.AVML));
    }

    @Test
    public void testRemoveDietaryRestriction() {
        victim.addDietaryRestriction(DietaryRestriction.AVML);
        victim.removeDietaryRestriction(DietaryRestriction.AVML);
        assertFalse("removeDietaryRestriction should remove a dietary restriction", victim.getDietaryRestrictions().contains(DietaryRestriction.AVML));
    }
}


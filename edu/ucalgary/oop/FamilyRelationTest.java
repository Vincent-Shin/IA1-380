package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FamilyRelationTest {
    private DisasterVictim peace;
    private DisasterVictim sam;
    private DisasterVictim diamond;
    private FamilyRelation peaceSamRelation;

    @Before
    public void setUp() {
        peace = new DisasterVictim("Peace", "2024-01-01");
        sam = new DisasterVictim("Sam", "2024-01-02");
        diamond = new DisasterVictim("Diamond", "2024-01-03");
        peaceSamRelation = new FamilyRelation(peace, "sibling", sam);
    }

    @Test
    public void testFamilyRelationCreation() {
        assertEquals("PersonOne should be Peace", peace, peaceSamRelation.getPersonOne());
        assertEquals("PersonTwo should be Sam", sam, peaceSamRelation.getPersonTwo());
        assertEquals("Relationship should be 'sibling'", "sibling", peaceSamRelation.getRelationshipTo());
    }

    @Test
    public void testAddFamilyRelationConsistency() {
        assertEquals("Peace should have 0 family connections initially", 0, peace.getFamilyConnections().length);
        assertEquals("Sam should have 0 family connections initially", 0, sam.getFamilyConnections().length);

        // Adding relationship to Peace's family connections
        peace.addFamilyConnection(peaceSamRelation);

        // Now both Peace and Sam should have the same family connection
        assertEquals("Peace should have 1 family connection", 1, peace.getFamilyConnections().length);
        assertEquals("Sam should have 1 family connection", 1, sam.getFamilyConnections().length);

        // Ensure consistency of family connections
        assertEquals("Peace's family connection should match", peaceSamRelation, peace.getFamilyConnections()[0]);
        assertEquals("Sam's family connection should match", peaceSamRelation, sam.getFamilyConnections()[0]);
    }

    @Test
    public void testRemoveFamilyRelationConsistency() {
        peace.addFamilyConnection(peaceSamRelation);
        sam.addFamilyConnection(peaceSamRelation);

        // Removing relationship from Peace's family connections
        peace.removeFamilyConnection(peaceSamRelation);

        // Now both Peace and Sam should have 0 family connections
        assertEquals("Peace should have 0 family connections", 0, peace.getFamilyConnections().length);
        assertEquals("Sam should have 0 family connections", 0, sam.getFamilyConnections().length);
    }

    @Test
    public void testDuplicateFamilyRelationPrevention() {
        peace.addFamilyConnection(peaceSamRelation);
        // Trying to add the same relation again should not change anything
        peace.addFamilyConnection(peaceSamRelation);

        assertEquals("Peace should have only 1 family connection", 1, peace.getFamilyConnections().length);
    }

    @Test
    public void testCompleteFamilyRelationStorage() {
        // Creating family relations between Peace, Sam, and Diamond
        FamilyRelation peaceSamRelation = new FamilyRelation(peace, "sibling", sam);
        FamilyRelation peaceDiamondRelation = new FamilyRelation(peace, "sibling", diamond);
        FamilyRelation samDiamondRelation = new FamilyRelation(sam, "sibling", diamond);

        // Adding relations
        peace.addFamilyConnection(peaceSamRelation);
        peace.addFamilyConnection(peaceDiamondRelation);
        sam.addFamilyConnection(samDiamondRelation);

        assertEquals("Peace should have 2 family connections", 2, peace.getFamilyConnections().length);
        assertEquals("Sam should have 2 family connections", 2, sam.getFamilyConnections().length);
        assertEquals("Diamond should have 2 family connections", 2, diamond.getFamilyConnections().length);
    }
}


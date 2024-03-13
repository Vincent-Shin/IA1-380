package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Test;

public class DietaryRestrictionTest {
    @Test
    public void testDietaryRestrictions() {
        assertEquals("AVML", DietaryRestriction.AVML.name());
        assertEquals("DBML", DietaryRestriction.DBML.name());
        assertEquals("GFML", DietaryRestriction.GFML.name());
        assertEquals("KSML", DietaryRestriction.KSML.name());
        assertEquals("LSML", DietaryRestriction.LSML.name());
        assertEquals("MOML", DietaryRestriction.MOML.name());
        assertEquals("PFML", DietaryRestriction.PFML.name());
        assertEquals("VGML", DietaryRestriction.VGML.name());
        assertEquals("VJML", DietaryRestriction.VJML.name());
    }
    public void testGetDietaryRestrictionFromString() {
        assertEquals(DietaryRestriction.AVML, DietaryRestriction.valueOf("AVML"));
        assertEquals(DietaryRestriction.DBML, DietaryRestriction.valueOf("DBML"));
        assertEquals(DietaryRestriction.GFML, DietaryRestriction.valueOf("GFML"));
        assertEquals(DietaryRestriction.KSML, DietaryRestriction.valueOf("KSML"));
        assertEquals(DietaryRestriction.LSML, DietaryRestriction.valueOf("LSML"));
        assertEquals(DietaryRestriction.MOML, DietaryRestriction.valueOf("MOML"));
        assertEquals(DietaryRestriction.PFML, DietaryRestriction.valueOf("PFML"));
        assertEquals(DietaryRestriction.VGML, DietaryRestriction.valueOf("VGML"));
        assertEquals(DietaryRestriction.VJML, DietaryRestriction.valueOf("VJML"));
    }
}
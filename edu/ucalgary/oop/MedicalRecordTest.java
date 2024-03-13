package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedicalRecordTest {

    @Test
    public void testConstructorAndGetters() {
        Location location = new Location("Hospital", "123 Main St");
        String treatmentDetails = "Treatment for flu";
        String dateOfTreatment = "2024-03-13";

        MedicalRecord medicalRecord = new MedicalRecord(location, treatmentDetails, dateOfTreatment);

        assertEquals("getLocation() should return the correct location", location, medicalRecord.getLocation());
        assertEquals("getTreatmentDetails() should return the correct treatment details", treatmentDetails, medicalRecord.getTreatmentDetails());
        assertEquals("getDateOfTreatment() should return the correct date of treatment", dateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFormatConstructor() {
        Location location = new Location("Hospital", "123 Main St");
        String treatmentDetails = "Treatment for flu";
        String invalidDateOfTreatment = "13/03/2024";

        new MedicalRecord(location, treatmentDetails, invalidDateOfTreatment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFormatSetter() {
        Location location = new Location("Hospital", "123 Main St");
        String treatmentDetails = "Treatment for flu";
        String dateOfTreatment = "2024-03-13";

        MedicalRecord medicalRecord = new MedicalRecord(location, treatmentDetails, dateOfTreatment);

        String invalidDateOfTreatment = "13/03/2024";
        medicalRecord.setDateOfTreatment(invalidDateOfTreatment);
    }

    @Test
    public void testSetter() {
        Location location = new Location("Hospital", "123 Main St");
        String treatmentDetails = "Treatment for flu";
        String dateOfTreatment = "2024-03-13";

        MedicalRecord medicalRecord = new MedicalRecord(location, treatmentDetails, dateOfTreatment);

        String newTreatmentDetails = "Updated treatment for flu";
        medicalRecord.setTreatmentDetails(newTreatmentDetails);
        assertEquals("setTreatmentDetails() should update the treatment details", newTreatmentDetails, medicalRecord.getTreatmentDetails());

        String newDateOfTreatment = "2024-03-14";
        medicalRecord.setDateOfTreatment(newDateOfTreatment);
        assertEquals("setDateOfTreatment() should update the date of treatment", newDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
}


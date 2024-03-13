package edu.ucalgary.oop;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GenderRetrievalTest {
    private GenderRetrieval genderRetrieval;

    @Before
    public void setUp() {
        genderRetrieval = new GenderRetrieval();
    }

    @Test
    public void testReadFromFile() throws IOException {
        String fileName = "GenderOptions.txt";
        genderRetrieval.readFromFile(fileName);
        ArrayList<String> expectedOptions = new ArrayList<>(Arrays.asList("boy", "gender queer", "girl", "man", "non-binary", "two-spirit", "woman"));
        assertEquals("Gender options should be loaded from file", expectedOptions, genderRetrieval.genderRetrieval());
    }
}

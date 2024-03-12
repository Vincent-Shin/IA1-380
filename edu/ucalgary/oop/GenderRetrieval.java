package edu.ucalgary.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenderRetrieval {
    private ArrayList<String> genderOptions;

    public GenderRetrieval() {
        this.genderOptions = new ArrayList<>();
    }

    // Method to retrieve gender options
    public ArrayList<String> genderRetrieval() {
        return genderOptions;
    }

    // Method to read gender options from file
    public void readFromFile(String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                genderOptions.add(line.trim());
            }
            System.out.println("Gender options loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading gender options from file: " + e.getMessage());
            throw e;
        }
    }
}


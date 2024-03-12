package edu.ucalgary.oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    // Method to establish a connection to the database
    public Connection connect() throws SQLException {
        Connection connection = null;
        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            throw e;
        }
        return connection;
    }

    // Method to store data in the database
    public boolean storeData(Object data) {
        boolean success = false;
        try (Connection connection = connect()) {
            // Example: Storing data in the database using PreparedStatement
            String sql = "INSERT INTO table_name (column1, column2) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Set parameters
            preparedStatement.setString(1, "value1");
            preparedStatement.setString(2, "value2");
            // Execute the statement
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data stored successfully in the database.");
                success = true;
            } else {
                System.out.println("Failed to store data in the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error storing data in the database: " + e.getMessage());
        }
        return success;
    }

    // Method to retrieve data from the database
    public Object retrieveData() {
        Object data = null;
        try (Connection connection = connect()) {
            // Example: Retrieving data from the database using PreparedStatement
            String sql = "SELECT * FROM table_name";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // Process the resultSet
            while (resultSet.next()) {
                // Example: Retrieving data from resultSet and storing it in an object
                // Replace this with your actual logic to process retrieved data
                String column1Value = resultSet.getString("column1");
                String column2Value = resultSet.getString("column2");
                // Create object or do further processing
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data from the database: " + e.getMessage());
        }
        return data;
    }
}

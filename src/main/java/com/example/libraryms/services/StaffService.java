package com.example.libraryms.services;

import com.example.libraryms.controllers.Dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffService {

    private Dbconfig dbconfig = new Dbconfig(); // Instance of the Dbconfig class

    // Method to add staff to the database
    public boolean addStaff(String fullName, String email, String username, String password) {
        String sql = "INSERT INTO staff (full_name, email, username, password) VALUES (?, ?, ?, ?)";

        try (Connection connection = dbconfig.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, fullName);
            statement.setString(2, email);
            statement.setString(3, username);
            statement.setString(4, password);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if the insertion was successful

        } catch (SQLException e) {
            System.err.println("Error adding staff to the database: " + e.getMessage());
            return false;
        }
    }
}

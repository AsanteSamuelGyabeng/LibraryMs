package com.example.libraryms.services;

import com.example.libraryms.controllers.Dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    private Dbconfig dbconfig = new Dbconfig(); // Instance of the Dbconfig class

    // Method to authenticate user credentials
    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM staff WHERE username = ? AND password = ?";

        try (Connection connection = dbconfig.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if a matching record is found

        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
            return false;
        }
    }
}

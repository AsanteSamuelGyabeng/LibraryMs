package com.example.libraryms.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconfig {
    private static String DB_URL = "jdbc:mysql://localhost:3306/librarymanagementsystem";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "";

    public Connection connect() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Connected to the database successfully");
            } else {
                System.out.println("Failed to connect to the database");
            }
            return connection;
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return null; // return null if connection fails
        }
    }
}

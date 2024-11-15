package com.example.libraryms.services;

import com.example.libraryms.controllers.Dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookLending {

    // Assuming you have a Dbconfig class to handle the DB connection
    Dbconfig conn = new Dbconfig();
    Connection con = conn.connect();

    public void lendBook(int bookId, int patronId) {
        String checkAvailabilityQuery = "SELECT is_available FROM books WHERE book_id = ?";
        String updateBookQuery = "UPDATE books SET is_available = 'no' WHERE book_id = ?";
        String insertLendRecordQuery = "INSERT INTO lend_records (book_id, patron_id) VALUES (?, ?)";

        try {
            // Check if the book is available
            PreparedStatement checkPs = con.prepareStatement(checkAvailabilityQuery);
            checkPs.setInt(1, bookId);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                String isAvailable = rs.getString("is_available");
                if (isAvailable.equalsIgnoreCase("1")) {
                    // Update the book's availability status
                    PreparedStatement updatePs = con.prepareStatement(updateBookQuery);
                    updatePs.setInt(1, bookId);
                    int updatedRows = updatePs.executeUpdate();

                    if (updatedRows > 0) {
                        // Insert a record into the lend_records table
                        PreparedStatement insertPs = con.prepareStatement(insertLendRecordQuery);
                        insertPs.setInt(1, bookId);
                        insertPs.setInt(2, patronId);
                        int insertedRows = insertPs.executeUpdate();

                        if (insertedRows > 0) {
                            System.out.println("Book successfully lent to the patron.");
                        } else {
                            System.out.println("Failed to create lend record.");
                        }
                    } else {
                        System.out.println("Failed to update book availability.");
                    }
                } else {
                    System.out.println("Book is currently unavailable.");
                }
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while processing the book lending.");
        }
    }
}

package com.example.libraryms.services;

import com.example.libraryms.controllers.Dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public  class BookManager {
    private String title;
    private String author;
    private String genre;
    private String is_available;

    Dbconfig connection = new Dbconfig();
    Connection conn = connection.connect();


    public void addBook() {
        // Add book to the database
        String sql = "INSERT INTO books(title, author, genre, is_available) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, genre);
            ps.setString(4, is_available);
            int insertedRows = ps.executeUpdate();
            if (insertedRows > 0) {
                System.out.println("Successfully added book");
            } else {
                System.out.println("Failed to add book");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deleteBook(String bookTitle) {
        // Delete book from the database
        String sql = "DELETE FROM books WHERE title = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookTitle);
            int deletedRows = ps.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Successfully deleted book");
            } else {
                System.out.println("No book found with the given title");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateBook(String bookTitle, String newAuthor, String newGenre, String newIsAvailable) {
        // Update book details in the database
        String sql = "UPDATE books SET author = ?, genre = ?, is_available = ? WHERE title = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newAuthor);
            ps.setString(2, newGenre);
            ps.setString(3, newIsAvailable);
            ps.setString(4, bookTitle);
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Successfully updated book");
            } else {
                System.out.println("No book found with the given title");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void retrieveBook(String bookTitle) {
        // Retrieve book details from the database
        String sql = "SELECT * FROM books WHERE title = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookTitle);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Genre: " + rs.getString("genre"));
                System.out.println("Is Available: " + rs.getString("is_available"));
            } else {
                System.out.println("No book found with the given title");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

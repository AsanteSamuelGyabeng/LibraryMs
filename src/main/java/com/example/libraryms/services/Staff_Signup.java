package com.example.libraryms.services;

import com.example.libraryms.controllers.Dbconfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

public class Staff_Signup {

    Dbconfig conn = new Dbconfig();
    Connection con = conn.connect();

    private String username;
    private String password;
    private String email;

    public Staff_Signup(String username,String password,String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean isValid() {

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Invalid username: cannot be empty");
            return false;
        }


        if (password == null || password.length() < 8 ||
                !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()].*")) {
            System.out.println("Invalid password: must be at least 8 characters long, contain a number, and a special character");
            return false;
        }


        if (email == null || !Pattern.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", email)) {
            System.out.println("Invalid email: incorrect format");
            return false;
        }

        return true;
    }

    public void addStaff() {
        if (!isValid()) {
            System.out.println("Staff member not added due to validation errors");
            return;
        }

        String sql = "INSERT INTO staff (username, password, email) VALUES ('"+ username +"','"+password+"','"+email+"')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            int insertedRows = ps.executeUpdate();
            if (insertedRows > 0) {
                System.out.println("Successfully added new member");
            } else {
                System.out.println("Failed to add new member");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

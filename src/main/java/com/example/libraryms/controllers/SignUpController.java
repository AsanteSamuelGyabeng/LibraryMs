package com.example.libraryms.controllers;

import com.example.libraryms.services.StaffService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label successLabel;

    private StaffService staffService = new StaffService(); // Create instance of the service class

    @FXML
    public void handleSignUp() {
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (fullName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            successLabel.setText("All fields are required!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            successLabel.setText("Passwords do not match!");
            return;
        }

        // Call the service to add the staff to the database
        boolean isAdded = staffService.addStaff(fullName, email, username, password);

        if (isAdded) {
            successLabel.setText("Staff registered successfully!");
        } else {
            successLabel.setText("Registration failed. Please try again.");
        }
    }
}

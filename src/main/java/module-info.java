module com.example.libraryms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Open packages for deep reflection (e.g., for JavaFX FXMLLoader)
    opens com.example.libraryms to javafx.fxml;
    opens com.example.libraryms.controllers to javafx.fxml;
    opens com.example.libraryms.services;

    // Export packages for use by other modules
    exports com.example.libraryms;
    exports com.example.libraryms.controllers;
}

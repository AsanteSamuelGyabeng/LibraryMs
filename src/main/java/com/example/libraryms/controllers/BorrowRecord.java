package com.example.libraryms.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BorrowRecord {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty borrowDate;
    private final StringProperty returnDate;

    public BorrowRecord(String id, String name, String borrowDate, String returnDate) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.borrowDate = new SimpleStringProperty(borrowDate);
        this.returnDate = new SimpleStringProperty(returnDate);
    }

    // Getter methods for the properties
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty borrowDateProperty() {
        return borrowDate;
    }

    public StringProperty returnDateProperty() {
        return returnDate;
    }
}

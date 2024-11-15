package com.example.libraryms.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

public class DashboardController {

    @FXML
    private StackPane mainContent;

    @FXML
    private Label defaultLabel;

    @FXML
    public void showDashboard() {
        // Create the dashboard label
        Label dashboardLabel = new Label("");
        dashboardLabel.setStyle("-fx-font-size: 20; -fx-padding: 20;");
        dashboardLabel.setTextFill(javafx.scene.paint.Color.web("#1a5276"));

        // Create an HBox for a flexible layout, with top alignment
        HBox layout = new HBox(10); // 10px space between divs
        layout.setStyle("-fx-padding: 20;"); // Padding at the top

        // Create 4 colored rectangles (simulating divs) with text labels
        StackPane stack1 = createDivWithLabel(0.22, 150, "#EC8305", "Books");
        StackPane stack2 = createDivWithLabel(0.22, 150, "#091057", "Borrowed Books");
        StackPane stack3 = createDivWithLabel(0.22, 150, "#024CAA", "Returned Books");
        StackPane stack4 = createDivWithLabel(0.22, 150, "#C62E2E", "Div 4");

        // Add the StackPanes (which contain divs and labels) to the layout
        layout.getChildren().addAll(stack1, stack2, stack3, stack4);

        // Clear any previous content and add the label and divs to the main content
        mainContent.getChildren().clear();
        mainContent.getChildren().addAll(dashboardLabel, layout);
    }

    // Helper method to create a div with a label on top (responsive width)
    private StackPane createDivWithLabel(double widthPercentage, double height, String color, String labelText) {
        // Create the colored rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(height);
        rectangle.setFill(Color.web(color));

        // Make the width a percentage of the parent container (responsive width)
        rectangle.widthProperty().bind(mainContent.widthProperty().multiply(widthPercentage)); // 22% of container width


        // Create the label for the rectangle
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 16;");

        // Create a StackPane to overlay the label on the rectangle
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, label);

        // Set alignment for the label to be centered in the rectangle
        StackPane.setAlignment(label, javafx.geometry.Pos.CENTER);

        return stackPane;
    }





    @FXML
    public void showBooks() {
        // Label
        Label borrowLabel = new Label("Library Books");
        borrowLabel.setStyle("-fx-font-size: 20; -fx-padding: 20;");
        borrowLabel.setTextFill(javafx.scene.paint.Color.web("#1a5276"));

        // TableView setup
        TableView<BorrowRecord> table = new TableView<>();
        table.setEditable(true);

        // Create columns for the table
        TableColumn<BorrowRecord, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        idColumn.setMinWidth(100);

        TableColumn<BorrowRecord, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn.setMinWidth(200);

        TableColumn<BorrowRecord, String> borrowDateColumn = new TableColumn<>("Borrow Date");
        borrowDateColumn.setCellValueFactory(cellData -> cellData.getValue().borrowDateProperty());
        borrowDateColumn.setMinWidth(150);

        TableColumn<BorrowRecord, String> returnDateColumn = new TableColumn<>("Return Date");
        returnDateColumn.setCellValueFactory(cellData -> cellData.getValue().returnDateProperty());
        returnDateColumn.setMinWidth(150);

        // Add columns to the table
        table.getColumns().add(idColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(borrowDateColumn);
        table.getColumns().add(returnDateColumn);

        // Sample data for demonstration
        ObservableList<BorrowRecord> data = FXCollections.observableArrayList(
                new BorrowRecord("1", "John Doe", "2024-11-01", "2024-11-10"),
                new BorrowRecord("2", "Jane Smith", "2024-11-05", "2024-11-12")
        );

        // Set data in the table
        table.setItems(data);

        // Create a VBox layout to hold both the label and the table
        VBox layout = new VBox(10);
        layout.getChildren().addAll(borrowLabel, table);
        layout.setStyle("-fx-padding: 20;");

        // Clear any previous content and add the VBox to the main content
        mainContent.getChildren().clear();
        mainContent.getChildren().add(layout);
    }

    @FXML
    public void showMembers() {
        Label membersLabel = new Label("Members Content");
        membersLabel.setStyle("-fx-font-size: 20; -fx-padding: 20;");
        membersLabel.setTextFill(javafx.scene.paint.Color.web("#1a5276"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(membersLabel);
    }

    @FXML
    public void showBorrowRecords() {
        // Label
        Label borrowLabel = new Label("Borrow Records Content");
        borrowLabel.setStyle("-fx-font-size: 20; -fx-padding: 20;");
        borrowLabel.setTextFill(javafx.scene.paint.Color.web("#1a5276"));

        // TableView setup
        TableView<BorrowRecord> table = new TableView<>();
        table.setEditable(true);

        // Create columns for the table
        TableColumn<BorrowRecord, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        idColumn.setMinWidth(100);

        TableColumn<BorrowRecord, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn.setMinWidth(200);

        TableColumn<BorrowRecord, String> borrowDateColumn = new TableColumn<>("Borrow Date");
        borrowDateColumn.setCellValueFactory(cellData -> cellData.getValue().borrowDateProperty());
        borrowDateColumn.setMinWidth(150);

        TableColumn<BorrowRecord, String> returnDateColumn = new TableColumn<>("Return Date");
        returnDateColumn.setCellValueFactory(cellData -> cellData.getValue().returnDateProperty());
        returnDateColumn.setMinWidth(150);

        // Add columns to the table
        table.getColumns().add(idColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(borrowDateColumn);
        table.getColumns().add(returnDateColumn);

        // Sample data for demonstration
        ObservableList<BorrowRecord> data = FXCollections.observableArrayList(
                new BorrowRecord("1", "John Doe", "2024-11-01", "2024-11-10"),
                new BorrowRecord("2", "Jane Smith", "2024-11-05", "2024-11-12")
        );

        // Set data in the table
        table.setItems(data);

        // Create a VBox layout to hold both the label and the table
        VBox layout = new VBox(10);
        layout.getChildren().addAll(borrowLabel, table);
        layout.setStyle("-fx-padding: 20;");

        // Clear any previous content and add the VBox to the main content
        mainContent.getChildren().clear();
        mainContent.getChildren().add(layout);
    }


    @FXML
    public void showReturnRecords() {
        // Label
        Label borrowLabel = new Label("Returned Books");
        borrowLabel.setStyle("-fx-font-size: 20; -fx-padding: 20;");
        borrowLabel.setTextFill(javafx.scene.paint.Color.web("#1a5276"));

        // TableView setup
        TableView<BorrowRecord> table = new TableView<>();
        table.setEditable(true);

        // Create columns for the table
        TableColumn<BorrowRecord, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        idColumn.setMinWidth(100);

        TableColumn<BorrowRecord, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn.setMinWidth(200);

        TableColumn<BorrowRecord, String> borrowDateColumn = new TableColumn<>("Borrow Date");
        borrowDateColumn.setCellValueFactory(cellData -> cellData.getValue().borrowDateProperty());
        borrowDateColumn.setMinWidth(150);

        TableColumn<BorrowRecord, String> returnDateColumn = new TableColumn<>("Return Date");
        returnDateColumn.setCellValueFactory(cellData -> cellData.getValue().returnDateProperty());
        returnDateColumn.setMinWidth(150);

        // Add columns to the table
        table.getColumns().add(idColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(borrowDateColumn);
        table.getColumns().add(returnDateColumn);

        // Sample data for demonstration
        ObservableList<BorrowRecord> data = FXCollections.observableArrayList(
                new BorrowRecord("1", "John Doe", "2024-11-01", "2024-11-10"),
                new BorrowRecord("2", "Jane Smith", "2024-11-05", "2024-11-12")
        );

        // Set data in the table
        table.setItems(data);

        // Create a VBox layout to hold both the label and the table
        VBox layout = new VBox(10);
        layout.getChildren().addAll(borrowLabel, table);
        layout.setStyle("-fx-padding: 20;");

        // Clear any previous content and add the VBox to the main content
        mainContent.getChildren().clear();
        mainContent.getChildren().add(layout);
    }

    @FXML
    public void showSettings() {
        Label settingsLabel = new Label("Settings Content");
        settingsLabel.setStyle("-fx-font-size: 20; -fx-padding: 20;");
        settingsLabel.setTextFill(javafx.scene.paint.Color.web("#1a5276"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(settingsLabel);
    }




}

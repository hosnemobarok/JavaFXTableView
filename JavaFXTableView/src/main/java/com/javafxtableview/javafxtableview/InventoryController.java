package com.javafxtableview.javafxtableview;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    // MARK: - Outlet variable

    @FXML
    TextField nameTextField;

    @FXML
    TextField priceTextField;

    @FXML
    TextField quantityTextField;

    @FXML
    TextArea descriptionTextArea;

    @FXML
    DatePicker dataPicker;

    // MARK: - SetupTable
    @FXML
    TableView<Product> inventoryTableView;

    @FXML
    TableColumn<Product, String> nameTableColumn;

    @FXML
    TableColumn<Product, Double> priceTableColumn;

    @FXML
    TableColumn<Product, Number> quantityTableColumn;

    @FXML
    TableColumn<Product, String> descriptionTableColumn;

    @FXML
    TableColumn<Product, LocalDate> dateTableColumn;

    @FXML
    ObservableList<Product> inventoryObservableList;


    // MARK: - ViewDidLoads - initialize
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
        priceTableColumn.setCellValueFactory(cell -> new SimpleDoubleProperty(cell.getValue().getPrice()).asObject());
        quantityTableColumn.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getQuantity()));
        descriptionTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescription()));
        dateTableColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getExpiryDate()));


        inventoryObservableList = FXCollections.observableArrayList();
        inventoryTableView.setItems(inventoryObservableList);

    }

    // MARK: - Button Action

    private void clearInputFields() {
        // Clear the input fields
        nameTextField.clear();
        priceTextField.clear();
        quantityTextField.clear();
        descriptionTextArea.clear();
        dataPicker.setValue(null); // Reset date picker
    }

    @FXML
    public void saveButtonAction() {
        try {
            // Get values from UI components
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());
            String description = descriptionTextArea.getText();
            LocalDate expiryDate = dataPicker.getValue();


            System.out.println(
                    name + " " +
                            price + " " +
                            quantity + " " +
                            description + " " +
                            expiryDate + " "
            );


            // Create a new Product object
            Product newProduct = new Product(name, price, quantity, description, expiryDate);

            // Add the new product to your inventory
            inventoryObservableList.add(newProduct);

            // Clear the input fields after saving
            clearInputFields();
        } catch (NumberFormatException e) {
            // Handle the case where parsing text to numbers fails (e.g., invalid number format)
            System.err.println("Invalid input format for price or quantity.");
        }
    }

    @FXML
    public void deleteButtonAction() {
        Product selectedProduct = inventoryTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            inventoryObservableList.remove(selectedProduct);
        } else {
            // Handle the case where no product is selected
            System.err.println("No product selected for deletion.");
        }
    }


}

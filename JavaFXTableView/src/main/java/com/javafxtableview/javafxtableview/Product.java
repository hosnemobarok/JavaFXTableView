package com.javafxtableview.javafxtableview;

import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String description;
    private LocalDate expiryDate;

    // Constructors
    public Product() {
        // Default constructor
    }

    public Product(String name, double price, int quantity, String description, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // You can override the toString() method for debugging or display purposes
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

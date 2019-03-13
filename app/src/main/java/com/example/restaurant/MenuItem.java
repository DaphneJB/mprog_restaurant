package com.example.restaurant;

public class MenuItem {
    private String description, name, imageUrl, category;
    private double price;

    public MenuItem(String description, String name, String imageUrl, String category, double price) {
        this.description = description;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

}

package com.example.restaurant;

import java.io.Serializable;
//represents an item on a menu with a given description, name, image url, price and category
public class MenuItem implements Serializable {
    private String description, name, imageUrl, price;

    public MenuItem(String description, String name, String imageUrl, String price) {
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

    public String getPrice() {
        return price;
    }
}

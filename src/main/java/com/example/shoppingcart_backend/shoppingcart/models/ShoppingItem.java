package com.example.shoppingcart_backend.shoppingcart.models;

public class ShoppingItem {
    private String id;
    private String itemName;
    private double price;
    private Integer ratings;
    private String imageUrl;


    public ShoppingItem() {
    }

    public ShoppingItem(String id, String itemName, double price, Integer ratings, String imageUrl) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.ratings = ratings;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", ratings=" + ratings +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

package com.example.shoppingcart_backend.shoppingcart.models;


public class ShoppingCart {
    private String shoppingcartId;
    private String test;

    public ShoppingCart(){}

    public ShoppingCart(String shoppingcartId, String test) {
        this.shoppingcartId = shoppingcartId;
        this.test = test;
    }

    public String getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(String shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

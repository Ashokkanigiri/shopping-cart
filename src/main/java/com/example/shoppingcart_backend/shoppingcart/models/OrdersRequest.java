package com.example.shoppingcart_backend.shoppingcart.models;

public class OrdersRequest {
    private int amount;
    private String currency;
    private String receipt;

    public OrdersRequest(int amount, String currency, String receipt) {
        this.amount = amount;
        this.currency = currency;
        this.receipt = receipt;
    }

    public OrdersRequest() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "OrdersRequest{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", receipt='" + receipt + '\'' +
                '}';
    }
}

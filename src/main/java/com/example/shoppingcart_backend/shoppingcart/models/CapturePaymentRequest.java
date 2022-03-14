package com.example.shoppingcart_backend.shoppingcart.models;

public class CapturePaymentRequest {
    private String amount;
    private String currency;

    public CapturePaymentRequest(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public CapturePaymentRequest() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CapturePaymentRequest{" +
                "amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}

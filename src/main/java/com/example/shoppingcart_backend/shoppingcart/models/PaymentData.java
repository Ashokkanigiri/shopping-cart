package com.example.shoppingcart_backend.shoppingcart.models;

import org.json.JSONObject;

public class PaymentData {
    private java.lang.String paymentId;
    private java.lang.String orderId;
    private java.lang.String signature;


    public PaymentData(String paymentId, String orderId, String signature) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.signature = signature;
    }

    public PaymentData() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
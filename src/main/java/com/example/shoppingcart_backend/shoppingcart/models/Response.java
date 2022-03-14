package com.example.shoppingcart_backend.shoppingcart.models;

import org.springframework.http.HttpStatus;

public class Response <T>{

    private HttpStatus statusCode;
    private T model;

    public Response(T s, HttpStatus ok) {
        this.statusCode = ok;
        this.model = s;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }



}

package com.example.shoppingcart_backend.shoppingcart.service;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

@Service
public class RazorPayService {

    @Value("${spring.datasource.key_id}")
    public String SECRET_ID;

    @Value("${spring.datasource.key_secret}")
    public String SECRET_KEY;
}

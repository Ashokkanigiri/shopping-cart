package com.example.shoppingcart_backend.shoppingcart.service;

import com.ashok.kanigiri.shoppingcart.service.models.OrdersRequest;
import com.google.gson.Gson;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class RazorPayService {

    @Value("${spring.datasource.key_id}")
    public String SECRET_ID;

    @Value("${spring.datasource.key_secret}")
    public String SECRET_KEY;

}

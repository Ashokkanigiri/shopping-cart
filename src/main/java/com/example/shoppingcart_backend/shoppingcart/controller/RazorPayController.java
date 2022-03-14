package com.example.shoppingcart_backend.shoppingcart.controller;

import com.example.shoppingcart_backend.shoppingcart.Signature;
import com.example.shoppingcart_backend.shoppingcart.models.CapturePaymentRequest;
import com.example.shoppingcart_backend.shoppingcart.models.OrdersRequest;
import com.example.shoppingcart_backend.shoppingcart.models.PaymentData;
import com.example.shoppingcart_backend.shoppingcart.service.RazorPayService;
import com.google.gson.Gson;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SignatureException;

@RestController("")
@PropertySource("classpath:application.properties")
public class RazorPayController {

    private RazorpayClient client;
    private static Gson gson = new Gson();

    private RazorPayService razorPayService;

    private String KEY = "rzp_test_D9BnmMuunk2smt";
    private String SECRET = "cOSIOpqAbClgIWg3JQ32UAyC";

    public RazorPayController(RazorPayService razorPayService) throws RazorpayException {
        this.razorPayService = razorPayService;
        this.client = new RazorpayClient(razorPayService.SECRET_ID, razorPayService.SECRET_KEY);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrdersRequest ordersRequest) {
        try {
            Order order = createRazorPayOrder(ordersRequest);
            return new ResponseEntity<String>(gson.toJson(order), HttpStatus.OK);
        } catch (RazorpayException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Error Occured While Creating Order", HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/verifySignature")
    public Boolean isSignatureValid(@RequestBody PaymentData paymentData) throws SignatureException {
        return paymentData.getSignature().equals( Signature.calculateRFC2104HMAC(paymentData.getOrderId() +"|"+ paymentData.getPaymentId(), razorPayService.SECRET_ID));
    }

    @PostMapping("/capturePayment/{paymentId}")
    public Boolean capturePayment(@PathVariable String paymentId, @RequestBody CapturePaymentRequest capturePaymentRequest) throws RazorpayException {
        try{
            JSONObject options = new JSONObject();
            options.put("amount", convertRupeeToPaise(capturePaymentRequest.getAmount()));
            options.put("currency", capturePaymentRequest.getCurrency());
            client.Payments.capture(paymentId, options);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private Order createRazorPayOrder(OrdersRequest ordersRequest) throws RazorpayException {
        JSONObject options = new JSONObject();
        options.put("amount", convertRupeeToPaise(""+ordersRequest.getAmount()));
        options.put("currency", ordersRequest.getCurrency());
        options.put("receipt", ordersRequest.getReceipt());
        return client.Orders.create(options);
    }

    private String convertRupeeToPaise(String paise) {
        BigDecimal b = new BigDecimal(paise);
        BigDecimal value = b.multiply(new BigDecimal("100"));
        return value.setScale(0, RoundingMode.UP).toString();
    }


}

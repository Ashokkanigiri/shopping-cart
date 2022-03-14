package com.ashok.kanigiri.shoppingcart.service.models

import com.example.shoppingcart_backend.shoppingcart.models.Notes

data class OrdersRequest (val amount: Int, val currency: String, val receipt: String)
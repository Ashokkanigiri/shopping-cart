package com.example.shoppingcart_backend.shoppingcart.controller;

import com.example.shoppingcart_backend.shoppingcart.Signature;
import com.example.shoppingcart_backend.shoppingcart.models.Response;
import com.example.shoppingcart_backend.shoppingcart.models.ShoppingCart;
import com.example.shoppingcart_backend.shoppingcart.models.ShoppingItem;
import com.example.shoppingcart_backend.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.SignatureException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

//    @Value("${spring.datasource.username}")
//    private String userBucketPath;

    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }
//
//    @GetMapping("/test")
//    public String testEndpoint(){
//        return shoppingCartService.getTestEndPoint();
//    }
//
//    @PostMapping("/insertcart")
//    public String insertShoppingCart(@RequestBody ShoppingCart shoppingCart) throws ExecutionException, InterruptedException {
//        return  shoppingCartService.testApi(shoppingCart).toString();
//    }
//
//    @GetMapping("/fetchcart")
//    public ShoppingCart getShoppingCart() throws ExecutionException, InterruptedException {
//        return shoppingCartService.testApiFetch();
//    }

    @GetMapping("/getAllItems")
    public List<ShoppingItem> getListOfAllShoppingItems() throws ExecutionException, InterruptedException {
//        System.out.println("******************"+userBucketPath);
        return shoppingCartService.getallShoppingItems();
    }

    @PostMapping("/addShoppingItem")
    public Response<String> addShoppingItemToCart(@RequestBody  ShoppingItem shoppingItem){
        return shoppingCartService.addItemToCart(shoppingItem);
    }

    @DeleteMapping("/deleteShoppingItem/{id}")
    public Response<String> deleteShoppingItem(@PathVariable("id") String id){
        return shoppingCartService.deleteShoppingItem(id);
    }


}

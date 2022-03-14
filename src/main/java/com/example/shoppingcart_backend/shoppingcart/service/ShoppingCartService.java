package com.example.shoppingcart_backend.shoppingcart.service;

import com.example.shoppingcart_backend.shoppingcart.models.Response;
import com.example.shoppingcart_backend.shoppingcart.models.ShoppingCart;
import com.example.shoppingcart_backend.shoppingcart.models.ShoppingItem;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ShoppingCartService {
    private String SHOPPING_ITEMS_COLLECTION = "shopping_items";

    public String getTestEndPoint() {
        return "End point is owrking fine";
    }

    public Timestamp testApi(ShoppingCart shoppingCart) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("1101").document(shoppingCart.getShoppingcartId()).set(shoppingCart);
        return apiFuture.get().getUpdateTime();
    }

    public ShoppingCart testApiFetch() throws ExecutionException, InterruptedException {
        DocumentSnapshot documentSnapshot = FirestoreClient.getFirestore().collection("1101").document("8IiumEXWiI8BqQzz43tK").get().get();
        return documentSnapshot.toObject(ShoppingCart.class);
    }

    public List<ShoppingItem> getallShoppingItems() throws ExecutionException, InterruptedException {
        Iterable<DocumentReference> shopping_items = FirestoreClient.getFirestore().collection(SHOPPING_ITEMS_COLLECTION).listDocuments();

        ArrayList<ShoppingItem> list = new ArrayList<>();
        for (DocumentReference jj : shopping_items) {
            list.add(jj.get().get().toObject(ShoppingItem.class));
        }
        return list;
    }

    public Response<String> addItemToCart(ShoppingItem shoppingItem) {
        try {
            FirestoreClient.getFirestore().collection(SHOPPING_ITEMS_COLLECTION).document(shoppingItem.getId()).set(shoppingItem);
        } catch (Exception e) {
            return new Response<String>("An Unknown Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new Response<String>("Item Added Sucessfully", HttpStatus.OK);
    }

    public Response<String> deleteShoppingItem(String shoppingItemId) {
        try {
            FirestoreClient.getFirestore().collection(SHOPPING_ITEMS_COLLECTION).document(shoppingItemId).delete();
        } catch (Exception e) {
            return new Response<String>("An Unknown Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new Response<String>("Item Deleted Sucessfully", HttpStatus.OK);

    }

}

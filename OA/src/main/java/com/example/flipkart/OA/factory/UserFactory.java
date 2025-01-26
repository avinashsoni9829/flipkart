package com.example.flipkart.OA.factory;

import com.example.flipkart.OA.models.Buyer;
import com.example.flipkart.OA.models.Seller;
import com.example.flipkart.OA.models.User;

public class UserFactory {
    public static User getUser(String type , String name){
         switch (type){
             case "BUYER": return  new Buyer(name);
             case "SELLER" : return new Seller(name);
             default: return null;
         }
    }
}

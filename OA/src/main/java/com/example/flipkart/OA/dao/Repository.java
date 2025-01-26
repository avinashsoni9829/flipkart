package com.example.flipkart.OA.dao;

import com.example.flipkart.OA.models.Buyer;
import com.example.flipkart.OA.models.Seller;
import com.example.flipkart.OA.service.AuctionManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Repository {
    private volatile static Repository instance;
    private Map<String, Buyer> buyerMap;
    private Map<String, Seller> sellerMap;

    private Map<String, AuctionManager> auctionManagerMap;


    public static Repository getInstance(){
         // SingleTon Class
         if(Objects.isNull(instance)){
             synchronized (Repository.class){
                  if(Objects.isNull(instance)){
                      instance = new Repository();
                  }
             }

         }

         return instance;
    }
    private Repository(){
        buyerMap = new HashMap<>();
        sellerMap = new HashMap<>();
        auctionManagerMap = new HashMap<>();
    }



    public Map<String, Buyer> getBuyerMap() {
        return buyerMap;
    }



    public Map<String, Seller> getSellerMap() {
        return sellerMap;
    }


    public Map<String, AuctionManager> getAuctionManagerMap() {
        return auctionManagerMap;
    }

}

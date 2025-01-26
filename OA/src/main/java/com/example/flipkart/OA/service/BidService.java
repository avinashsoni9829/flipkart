package com.example.flipkart.OA.service;

import com.example.flipkart.OA.models.Buyer;

public class BidService {
    private AuctionManager auctionManager;
    public BidService(AuctionManager auctionManager){
         this.auctionManager = auctionManager;
    }

    public boolean processBid(Buyer buyer,double amount){
         return auctionManager.processBid(buyer,amount);
    }

    public boolean withdrawBid(Buyer buyer){
         return auctionManager.withDrawBid(buyer);
    }
}

package com.example.flipkart.OA.service;

import com.example.flipkart.OA.models.Bid;
import com.example.flipkart.OA.models.Buyer;

public interface AuctionMethods {
    boolean processBid(Buyer buyer,double amount);

    boolean withDrawBid(Buyer buyer);

    void closeAuction();

    Bid getWinner();

    double computeProfit();

}

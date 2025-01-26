package com.example.flipkart.OA.service;

import com.example.flipkart.OA.models.Bid;
import com.example.flipkart.OA.models.Buyer;

public interface BidManagerActions {
    void addBid(Bid bid);
    void updateBid(Buyer buyer, double amount);

    boolean removeBid(Buyer buyer);

    boolean hasBid(Buyer buyer);

    Bid getWinner();

}

package com.example.flipkart.OA.strategy;

import com.example.flipkart.OA.service.AuctionManager;
import com.example.flipkart.OA.service.BidManager;

public interface ProfitComputationStrategy {
    double computeProfit(AuctionManager auctionManager , BidManager bidManager);
}

package com.example.flipkart.OA.service;

import com.example.flipkart.OA.strategy.ProfitComputationStrategy;



public class ProfitComputer {
    private ProfitComputationStrategy profitComputationStrategy;

    public ProfitComputer(ProfitComputationStrategy strategy){
         this.profitComputationStrategy = strategy;
    }


    public double computeProfit(AuctionManager auctionManager , BidManager bidManager){
         return profitComputationStrategy.computeProfit(auctionManager,bidManager);
    }
}

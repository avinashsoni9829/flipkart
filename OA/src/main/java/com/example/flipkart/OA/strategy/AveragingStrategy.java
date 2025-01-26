package com.example.flipkart.OA.strategy;

import com.example.flipkart.OA.models.Bid;
import com.example.flipkart.OA.service.AuctionManager;
import com.example.flipkart.OA.service.BidManager;

import java.util.Objects;

public class AveragingStrategy implements ProfitComputationStrategy{
    private static double percentageCost = 0.2;
    @Override
    public double computeProfit(AuctionManager auctionManager, BidManager bidManager) {
        double winnerAmount = 0;
        Bid winner = auctionManager.getWinner();
        if(Objects.nonNull(winner)){
            winnerAmount = winner.getAmount();
        }
        int totalUser = bidManager.getCountOfUser();
        double participantShare = totalUser * auctionManager.getCost() * percentageCost;
        if(winnerAmount!=0.0){
            double avgBidLimit = (auctionManager.getLowLimit() + auctionManager.getHighLimit())/2;
            return winnerAmount + participantShare - avgBidLimit;
        }
        return participantShare;
    }
}

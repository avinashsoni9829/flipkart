package com.example.flipkart.OA.service;

import com.example.flipkart.OA.factory.ProfitStrategyFactory;
import com.example.flipkart.OA.models.Bid;
import com.example.flipkart.OA.models.Buyer;
import com.example.flipkart.OA.models.Seller;

public class AuctionManager implements AuctionMethods {
    private String id;
    private double lowLimit;
    private double highLimit;

    private double cost;

    private Seller seller;
    private  BidManager bidManager;

    private ProfitComputer profitCalculator;

    private boolean isActive;

    public AuctionManager(String id , double lowLimit, double highLimit , double participationCost, Seller seller, String profitComputationStrategy)
    {
         this.id = id;
         this.lowLimit = lowLimit;
         this.highLimit = highLimit;
         this.cost = participationCost;
         this.seller = seller;
         this.bidManager = new BidManager();
         this.profitCalculator = new ProfitComputer(ProfitStrategyFactory.getStrategy(profitComputationStrategy));
         this.isActive = true;
    }

    public double getLowLimit() {
        return lowLimit;
    }


    public double getHighLimit() {
        return highLimit;
    }



    public double getCost() {
        return cost;
    }






    @Override
    public boolean processBid(Buyer buyer, double amount) {
        // Check if Auction Is Closed
        if(!isActive){
            System.out.println("Auction is Closed");
            return false;
        }

        if(amount < lowLimit || amount > highLimit){
            System.out.println("Out of Bound Bid");
            return false;
        }

        if(!bidManager.hasBid(buyer)){
            // Preferred Buyer Setting
            buyer.incrementAuctionsParticipated();
            if(buyer.getAuctionsParticipated() > 2){
                 buyer.setPreferred(true);
            }
            bidManager.addBid(new Bid(buyer,amount));
        }
        else {
            bidManager.updateBid(buyer,amount);
        }
        return true;
    }

    @Override
    public boolean withDrawBid(Buyer buyer) {
        if(!isActive){
            System.out.println("Auction is Closed");
            return false;
        }
        return bidManager.removeBid(buyer);

    }

    @Override
    public void closeAuction() {
             isActive = false;
    }

    @Override
    public Bid getWinner() {
        if(!isActive){
            System.out.println("Auction is Closed");
            return null;
        }
        return bidManager.getWinner();
    }

    @Override
    public double computeProfit() {
        return profitCalculator.computeProfit(this,bidManager);
    }
}

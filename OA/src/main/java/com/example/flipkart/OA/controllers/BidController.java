package com.example.flipkart.OA.controllers;

import com.example.flipkart.OA.models.Buyer;
import com.example.flipkart.OA.service.AuctionManager;
import com.example.flipkart.OA.service.AuctionMethods;
import com.example.flipkart.OA.service.BidManager;
import com.example.flipkart.OA.service.BidService;

import java.util.Objects;

public class BidController {
    private UserController userController;
    private AuctionController auctionController;

    public BidController(UserController userController, AuctionController auctionController){
         this.userController = userController;
         this.auctionController = auctionController;
    }

    /**
     * To Process The Bid
     * @param buyerName
     * @param auctionId
     * @param amount
     */
    public void processBid(String buyerName,String auctionId , double amount){
        Buyer buyer = userController.getBuyer(buyerName);
        if(Objects.isNull(buyer)){
            System.out.println("Buyer Not Found");
            return;
        }
        AuctionManager manager = auctionController.getAuction(auctionId);
        if(Objects.isNull(manager)){
            System.out.println("Auction Not Found");
            return;
        }

        BidService bidService = new BidService(manager);
        if(bidService.processBid(buyer,amount)){
            System.out.println("Bid placed/updated by " + buyerName + " on auction " + auctionId + " with amount " + amount);
        }
    }

    /**
     * To Withdraw the Bid
     * @param buyerName
     * @param auctionId
     */
    public void withdrawBid(String buyerName, String auctionId){
        Buyer buyer = userController.getBuyer(buyerName);

        if(Objects.isNull(buyer)){
            System.out.println("Buyer Not Found");
            return;
        }
        AuctionManager manager = auctionController.getAuction(auctionId);
        if(Objects.isNull(manager)){
            System.out.println("Auction Not Found");
            return;
        }

        BidService bidService = new BidService(manager);
        if(bidService.withdrawBid(buyer)){
            System.out.println("Bid withdrawn by " + buyerName + " from auction " + auctionId);
        }

    }
}

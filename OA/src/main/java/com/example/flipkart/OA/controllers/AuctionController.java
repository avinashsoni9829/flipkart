package com.example.flipkart.OA.controllers;

import com.example.flipkart.OA.dao.Repository;
import com.example.flipkart.OA.models.Bid;
import com.example.flipkart.OA.models.Seller;
import com.example.flipkart.OA.service.AuctionManager;

import java.util.Objects;

public class AuctionController {
    private Repository repository;
    private UserController userController;

    public AuctionController(UserController userController){
        this.userController = userController;
        this.repository = Repository.getInstance();
    }

    /**
     * For Creating the Auction
     * @param id
     * @param lowLimit
     * @param highLimit
     * @param participationCost
     * @param sellerName
     */
    public void createAuction(String id, double lowLimit , double highLimit , double participationCost , String sellerName)
    {
          if(repository.getAuctionManagerMap().containsKey(id)){
              System.out.println("Auction Already Exists");
              return;
          }

         Seller seller = userController.getSeller(sellerName);
         if(Objects.isNull(seller)){
             System.out.println("Seller Not available");
             return;
         }

         AuctionManager auctionManager = new AuctionManager(id,lowLimit,highLimit,participationCost,seller,"AVERAGING");
         repository.getAuctionManagerMap().put(id,auctionManager);
         System.out.println("Auction Created " + id);
    }

    /** Fetching the Auction
     * @param auctionId
     * @return
     */
    public AuctionManager getAuction(String auctionId) {
        return repository.getAuctionManagerMap().get(auctionId);
    }

    /**
     * To Close the Auction
     * @param auctionId
     */
    public void getWinner(String auctionId) {
        AuctionManager auction = getAuction(auctionId);
        if (Objects.isNull(auction)) {
            System.out.println("Auction not found.");
            return;
        }

        Bid winningBid = auction.getWinner();
        if (Objects.nonNull(winningBid)) {
            System.out.println(" Winner: " + winningBid.getBuyer().getUserName() + " with bid " + winningBid.getAmount());
        } else {
            System.out.println(" No winner.");
        }

    }

    /**
     *  To Compute the Profit
     * @param sellerName
     * @param auctionId
     */
    public void computeProfitAndClose(String sellerName , String auctionId){
       Seller seller = userController.getSeller(sellerName);
        if(Objects.isNull(seller)){
            System.out.println("Seller Not Found");
            return;
        }
         AuctionManager manager = getAuction(auctionId);
        if (Objects.isNull(manager)) {
            System.out.println("Auction not found.");
            return;
        }

        double profit = manager.computeProfit();
        System.out.println("Profit/Loss for seller " + sellerName + " on auction " + auctionId + " is " + profit);
        manager.closeAuction();
        System.out.println("Auction" + auctionId + "is closed");

    }


}








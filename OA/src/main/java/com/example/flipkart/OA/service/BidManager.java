package com.example.flipkart.OA.service;

import com.example.flipkart.OA.models.Bid;
import com.example.flipkart.OA.models.Buyer;

import java.util.*;

public class BidManager implements BidManagerActions {
    int countOfUser;
    private Map<Buyer, Bid> bids;

    public BidManager(){
         this.bids = new HashMap<>();
    }


    @Override
    public void addBid(Bid bid) {
            bids.put(bid.getBuyer(),bid);
            countOfUser++;
    }

    @Override
    public void updateBid(Buyer buyer, double amount) {
        if(bids.containsKey(buyer)){
            bids.get(buyer).setAmount(amount);
        }
        else {
            System.out.println("Bid Not Found");
        }
    }

    @Override
    public boolean removeBid(Buyer buyer) {
        if(bids.containsKey(buyer)){
            bids.remove(buyer);
            return true;
        }
        else {
            System.out.println("Bid Not found");
            return false;
        }

    }

    @Override
    public boolean hasBid(Buyer buyer) {
       return bids.containsKey(buyer);
    }

    /**
     *  Strategy Can Be applied here
     */
    @Override
    public Bid getWinner() {
        Map<Double, List<Buyer>> amountToBuyer = new TreeMap<>(Collections.reverseOrder());
        for(Bid b : bids.values()){
             double amt = b.getAmount();
             amountToBuyer.putIfAbsent(amt,new ArrayList<>());
             amountToBuyer.get(amt).add(b.getBuyer());
        }

        for(Map.Entry<Double,List<Buyer>> entry : amountToBuyer.entrySet()){
             List<Buyer> buyers = entry.getValue();

             if(buyers.size() == 1){
                 return new Bid(buyers.get(0),entry.getKey());
             }
             else {
                 // preferred buyer case
                  List<Buyer> preferred = new ArrayList<>();
                  for(Buyer buyer : buyers){
                       if(buyer.isPreferred()){

                           preferred.add(buyer);
                       }
                  }

                  if(preferred.size() ==1){
                       return new Bid(preferred.get(0),entry.getKey());
                  }
                  else{
                      System.out.println("Tie Between Multiple Buyers");
                      continue;
                  }
             }
        }
        System.out.println("No Unique Bids");
         return null;
      }
      public int getCountOfUser(){
        return countOfUser;
      }
}

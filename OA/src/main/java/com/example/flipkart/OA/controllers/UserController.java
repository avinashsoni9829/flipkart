package com.example.flipkart.OA.controllers;

import com.example.flipkart.OA.dao.Repository;
import com.example.flipkart.OA.factory.UserFactory;
import com.example.flipkart.OA.models.Buyer;
import com.example.flipkart.OA.models.Seller;

import java.util.logging.Logger;

public class UserController {

    private Repository repository;
    public UserController(){
        repository = Repository.getInstance();
    }

    /**
     * To add the Buyer
     * @param name
     */
    public void addBuyer(String name){
         if(!repository.getBuyerMap().containsKey(name)){
             repository.getBuyerMap().put(name,(Buyer) UserFactory.getUser("BUYER",name));
             System.out.println("Buyer Added");
         }
         else {
             System.out.println("Buyer Already Exists");
         }
    }


    /** To add the Seller
     * @param name
     */
    public void addSeller(String name){
        if(!repository.getSellerMap().containsKey(name)){
            repository.getSellerMap().put(name,(Seller) UserFactory.getUser("SELLER",name));
            System.out.println("Seller Added");
        }
        else {
            System.out.println("Seller Already Exists");
        }
    }

    /** To fetch the Buyer
     * @param name
     * @return
     */
    public Buyer getBuyer(String name){
        return  repository.getBuyerMap().get(name);
    }

    /**
     *  To fetch the Seller
     * @param name
     * @return
     */
    public Seller getSeller(String name){
         return repository.getSellerMap().get(name);
    }
}

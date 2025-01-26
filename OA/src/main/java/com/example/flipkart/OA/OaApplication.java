package com.example.flipkart.OA;

import com.example.flipkart.OA.controllers.AuctionController;
import com.example.flipkart.OA.controllers.BidController;
import com.example.flipkart.OA.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
		UserController userController = new UserController();
		AuctionController auctionController = new AuctionController(userController);
		BidController bidController = new BidController(userController,auctionController);
//
//		// TC : 1
//		System.out.println("TC - 1");
		userController.addBuyer("buyer1");
		userController.addBuyer("buyer2");
		userController.addBuyer("buyer3");
		userController.addSeller("seller1");
        auctionController.createAuction("A1",10,50,1,"seller1");
		bidController.processBid("buyer1","A1",19);
		bidController.processBid("buyer2","A1",15);
		bidController.processBid("buyer2","A1",19);
		bidController.withdrawBid("buyer2","A1");
        bidController.processBid("buyer3","A1",19);
		bidController.withdrawBid("buyer3","A1");
		auctionController.getWinner("A1");
        auctionController.computeProfitAndClose("seller1","A1");


		// TC : 2
		System.out.println("TC - 2");
		userController.addSeller("seller2");
		auctionController.createAuction("A2", 5, 20, 2, "seller2");
		bidController.processBid("buyer3", "A2", 25);
		bidController.processBid("buyer2", "A2", 5);
		bidController.withdrawBid("buyer2", "A2");
		bidController.processBid("seller1","A2",100);
		auctionController.getWinner("A2");
		auctionController.computeProfitAndClose("seller2", "A2");




	}

}

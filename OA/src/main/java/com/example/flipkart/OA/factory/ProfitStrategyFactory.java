package com.example.flipkart.OA.factory;

import com.example.flipkart.OA.strategy.AveragingStrategy;
import com.example.flipkart.OA.strategy.ProfitComputationStrategy;

public class ProfitStrategyFactory {
    public static ProfitComputationStrategy getStrategy(String strategyName){
         switch (strategyName){
             case "AVERAGING" : return new AveragingStrategy();
             default: return null;
         }
    }
}

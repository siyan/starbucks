package com.sywood.starbucks.ben.DadsWork;

public class Greedy {

    public static void main(String[] args){
        int V = 42;
        int n = 4;
        int[] coinValue = new int[n];
        coinValue[0] = 25;
        coinValue[1] = 10;
        coinValue[2] = 5;
        coinValue[3] = 1;
        int coinCount = 0;
        while (V > 0){
            for (int coin : coinValue){
                if (V - coin >= 0){
                    V -= coin;
                    coinCount++;
                }
            }
        }
        System.out.println(coinCount);
    }
}

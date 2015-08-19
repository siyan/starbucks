package com.sywood.starbucks.ben;

import java.util.ArrayList;
import java.util.Scanner;

public class coinStack {
    public static ArrayList coinFlip( ArrayList coins, int n ) {

        ArrayList flipped = new ArrayList();

        for( int i = 0; i < n; i++ ) {
            int j = n-i-1;
            if ( "T".equals(coins.get(j))) {
                flipped.add( "H");
            }
            else {
                flipped.add("T");
            }
        }

        for (int i = n; i < coins.size(); i++) {
            flipped.add(coins.get(i));
        }

        return flipped;
    }
    public static boolean hasTails(ArrayList coins) {
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i) == "T") {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the number of coins?: ");
        int numCoins = input.nextInt();
        int totFlips = 0;
        boolean allH = false;
        ArrayList coins = new ArrayList();
        for (int i = 0; i < numCoins; i++) {
            coins.add("H");
        }
        do{
            for (int i = 1; i <= numCoins; i++) {
                coins = coinFlip(coins, i);
                totFlips += 1;
                if (!hasTails(coins) && totFlips != 0) {
                    allH = true;
                    break;
                }
            }
        }while (!allH);
        System.out.print("The total number of coin flips was: " + totFlips);
    }
}

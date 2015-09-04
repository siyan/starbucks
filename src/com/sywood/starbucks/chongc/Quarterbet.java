package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/9/2.
 */
import java.util.Scanner;
public class Quarterbet {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("How many coins does she has?");
        int coinHas = input.nextInt();
        System.out.println("How many times has the first machine been played since paying out? ");
        int since1 = input.nextInt();
        System.out.println("How many times has the second machine been played since paying out? ");
        int since2 = input.nextInt();
        System.out.println("How many times has the third machine been played since paying out? ");
        int since3 = input.nextInt();

        System.out.println("She plays "+ Quarter(coinHas,since1,since2,since3) + " times befor going broke");





    }

    public static int Quarter(int oriCoin, int coin1, int coin2, int coin3){
        if(oriCoin>= 100- coin2){
            return 100-coin2 + Quarter(oriCoin-40+coin2,coin1,0,coin3);
        }else{
            if(oriCoin>=35-coin1){
                return 35-coin1 + Quarter(oriCoin -5+coin1,0,coin2,coin3);
            }else{
                if(oriCoin>=10-coin3){
                    return 10-coin3 + Quarter(oriCoin-1+coin3,coin1,coin2,0);
                }
            }
        }

        return 0;
    }



}

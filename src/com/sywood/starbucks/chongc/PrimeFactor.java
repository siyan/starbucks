package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/9/9.
 */

// this is usd to assist me to finish my school assignment.
import java.util.Scanner;
public class PrimeFactor {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(primeBreakdown(num));
    }

    public static String primeBreakdown(int num){
        String result = "";
        for(int i=2;i<=num;i++){
            if(num % i ==0){
                if(num!=i) {
                    return i + "*" + primeBreakdown(num / i);
                }else{
                    return i+"";
                }
            }
        }
        return null;
    }
}

package com.sywood.starbucks.ben.DadsWork;
import java.util.Scanner;

/**
 * Created by Striker on 2015-11-06.
 */
public class Snail {
    public static int rem(String b){
        int ret = 0;
        for (int i = 0; i < b.length() ; i++) {
            if (b.charAt(i) != ' '){
                ret += 1;
            }else{
                return ret;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        double H = (double) inp.nextInt();
        double U = (double) inp.nextInt();
        double D = (double) inp.nextInt();
        double F = (double) inp.nextInt();

        int day = 0;
        double height = 0;
        double fatigue = U*(F/100);
        while(H > height & height >= 0 ){
            height += U;
            U -= fatigue;
            height -= D;
            day += 1;
            if (U <= 0){
                U = 0;
                fatigue = 0;
            }
        }
        if (height <= 0){
            System.out.print("Failure on day " + day);
        }else{
            day -= 1;
            System.out.print("Success on day " + day);
        }
    }
}

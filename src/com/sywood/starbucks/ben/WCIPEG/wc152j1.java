package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class wc152j1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iter = input.nextInt();
        if (iter == 1){
            System.out.println("A long time ago in a galaxy far away...");
        }else{
            String ret = "A long time ago in a galaxy ";
            for (int i = 0; i < iter-1; i++) {
                ret += "far, ";
            }
            System.out.println(ret + "far away...");
        }
    }
}

package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;

public class Waterloo20113 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = Integer.parseInt(input.nextLine());
        int b = Integer.parseInt(input.nextLine());
        int iters = 0;
        while (a > b){
            if (b > a){
                a -= b;
                iters += 1;
            }
        }
        System.out.print(iters);
    }
}

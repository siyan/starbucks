package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;

public class Waterloo20112 {
    public static boolean hitGround(int h, int t){
        boolean ground = false;
        if ((-6*Math.pow(t, 4) + h*Math.pow(t, 3) + 2*Math.pow(t, 2) + t) <= 0){
            ground = true;
        }
        return ground;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean hit = false;
        int hour = 0;
        int h = Integer.parseInt(input.nextLine());
        int M = Integer.parseInt(input.nextLine());
        for (int t = 1; t < M; t++){
            System.out.println(t);
            if (hitGround(h, t)) {
                hit = true;
                hour = t;
            }
        }
        if (hit){
            System.out.println("The balloon first touches ground at hour:");
            System.out.print(hour);
        }else{
            System.out.print("The balloon does not touch ground in the given time.");
        }
    }
}

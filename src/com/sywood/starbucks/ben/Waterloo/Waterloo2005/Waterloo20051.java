package com.sywood.starbucks.ben.Waterloo.Waterloo2005;
import java.util.Scanner;

public class Waterloo20051 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Number of daytime minutes?");
        double day = Integer.parseInt(input.nextLine());
        System.out.println("Number of evening minutes?");
        double eve = Integer.parseInt(input.nextLine());
        System.out.println("Number of weekend minutes?");
        double weekend = Integer.parseInt(input.nextLine());
        double A = 0;
        double B = 0;
        if (day > 100){
            A = (day-100)*0.25;
            if (day > 250){
                B = (day - 250)*0.45;
            }
        }
        A += eve*0.15;
        B += eve*0.35;
        A += weekend*0.2;
        B += weekend*0.25;

        System.out.println("Plan A costs " + A);
        System.out.println("Plan B costs " + B);
        if (A < B){
            System.out.print("Plan A is cheapest");
        }else if (B < A){
            System.out.print("Plan B is cheapest");
        }else{
            System.out.print("Plan A and Plan B are the same price.");
        }
    }
}

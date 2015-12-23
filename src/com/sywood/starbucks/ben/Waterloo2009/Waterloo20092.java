package com.sywood.starbucks.ben.Waterloo2009;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20092 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> fishVal = new ArrayList<>();
        int trout = Integer.parseInt(input.nextLine());
        int pike = Integer.parseInt(input.nextLine());
        int piker = Integer.parseInt(input.nextLine());
        fishVal.add(trout);
        fishVal.add(pike);
        fishVal.add(piker);
        int tot = Integer.parseInt(input.nextLine());
        int combos = 0;
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> fish = new ArrayList<>(3);
            int curr = fish.get(i);
            int sum = 0;
            while (sum <= tot){
                if (sum + curr <= tot){
                    fish.add(i, fish.get(i)+1);
                    sum += curr;
                    combos++;
                    System.out.println(fish.get(0) + " Brown Trout " + fish.get(1) + " Northern Pike " + fish.get(2) + " Yellow Pickerel");
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + combos);
    }
}

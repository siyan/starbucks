package com.sywood.starbucks.ben.Waterloo.Waterloo2009;
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
            ArrayList<Integer> fish = new ArrayList<>();
            fish.add(0);
            fish.add(0);
            fish.add(0);
            int curr = fishVal.get(i);
            int sum = 0;
            int currCombo = 0;
            while (sum < tot){
                if (sum + curr <= tot){
                    currCombo++;
                    fish.set(i, currCombo);
                    sum += curr;
                    combos++;
                    System.out.println(fish.get(0) + " Brown Trout " + fish.get(1) + " Northern Pike " + fish.get(2) + " Yellow Pickerel");
                    int otherCurrCombo = 0;
                    int currSum = sum;
                    for (int j = 1; j < 3; j++) {
                        int otherCurr = fishVal.get(j);
                        while (currSum < tot) {
                            if (currSum + otherCurr <= tot) {
                                otherCurrCombo++;
                                fish.set(j, otherCurrCombo);
                                currSum += otherCurr;
                                combos++;
                                System.out.println(fish.get(0) + " Brown Trout " + fish.get(1) + " Northern Pike " + fish.get(2) + " Yellow Pickerel");
                            }else{
                                currSum = tot+1;
                            }
                        }
                    }
                }else{
                    sum = tot+1;
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + combos);
    }
}

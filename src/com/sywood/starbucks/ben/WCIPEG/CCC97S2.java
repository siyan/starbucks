package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;
import java.util.ArrayList;

public class CCC97S2 {
    private static boolean contains(ArrayList<int[]> sums, int value){
        for (int[] values : sums){
            for (int num : values){
                if (num == value){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iter = Integer.parseInt(input.nextLine());
        for (int i = 0; i <= iter; i++){
            ArrayList<Integer> factors = new ArrayList<>();
            int num = input.nextInt();
            for (int j = 1; j < num; j++) {
                if (num % j == 0){
                    factors.add(j);
                }
            }
            ArrayList<int[]> sums = new ArrayList<>();
            int combos = 0;
            for (int factor : factors){
                for (int factor2 : factors.subList(1, factors.size()-1)){
                    int sum = factor + factor2;
                    int diff = factor - factor2;
                    int prod = factor * factor2;
                    if (contains(sums, sum) | contains(sums, diff)|contains(sums,prod)){
                        combos++;
                    }else{
                        sums.add(new int[]{sum, diff, prod});
                    }
                }
            }
            if (combos > 0){
                System.out.println(num + " is nasty.");
            }else{
                System.out.println(num + " is not nasty.");
            }
        }
    }
}

package com.sywood.starbucks.ben.Waterloo.Waterloo2005;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20052 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int combos = 0;
        System.out.println("Enter the lower limit of range");
        int lower = Integer.parseInt(input.nextLine());
        System.out.println("Enter the upper limit of range");
        int upper = Integer.parseInt(input.nextLine());
        for (int i = lower; i <= upper; i++) {
            ArrayList<Integer> factors = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (i%j == 0){
                    factors.add(j);
                }
            }
            if (factors.size() == 4){
                combos++;
            }
        }
        System.out.println("The number of RSA numbers between " + lower + " and " + upper + " is " + combos);
    }
}

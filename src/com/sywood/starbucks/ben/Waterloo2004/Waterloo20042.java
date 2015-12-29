package com.sywood.starbucks.ben.Waterloo2004;
import java.util.Scanner;

public class Waterloo20042 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the current year:");
        int curr = Integer.parseInt(input.nextLine());
        System.out.println("Enter a future year:");
        int next = Integer.parseInt(input.nextLine());
        for (int i = curr; i <= next; i++) {
            if (i % 5 == 0 & i % 2 == 0 & i % 3 == 0 & i % 4 == 0){
                System.out.println("All positions change in year " + i);
            }
        }
    }
}

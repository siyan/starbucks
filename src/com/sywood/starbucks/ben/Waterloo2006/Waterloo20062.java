package com.sywood.starbucks.ben.Waterloo2006;
import java.util.Scanner;

public class Waterloo20062 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = Integer.parseInt(input.nextLine());
        System.out.print("Enter n: ");
        int n = Integer.parseInt(input.nextLine());
        int combos = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + j == 10){
                    combos++;
                }
            }
        }
        if (combos == 1){
            System.out.println("There is 1 way to get the sum 10");
        }else {
            System.out.println("There are " + combos + " ways to get the sum 10");
        }
    }
}

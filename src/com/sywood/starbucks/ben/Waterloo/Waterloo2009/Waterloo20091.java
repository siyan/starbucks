package com.sywood.starbucks.ben.Waterloo.Waterloo2009;
import java.util.Scanner;

public class Waterloo20091 {
    public static void main(String[] args){
        int sum = 9+7*3+8+9+2*3+1+4*3+1+8*3;
        Scanner input = new Scanner(System.in);
        System.out.print("Digit 11? ");
        int eleven = Integer.parseInt(input.nextLine());
        System.out.print("Digit 12? ");
        int twelve = Integer.parseInt(input.nextLine())*3;
        System.out.print("Digit 13? ");
        int thirteen = Integer.parseInt(input.nextLine());
        sum = sum + eleven + twelve + thirteen;
        System.out.println("The 1-3-sum is " + sum);
    }
}

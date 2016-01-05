package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Scanner;

public class Waterloo20151 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int month = Integer.parseInt(input.nextLine());
        int day = Integer.parseInt(input.nextLine());
        if (month < 2){
            System.out.println("Before");
        }else if (month == 2 & day == 18){
            System.out.println("Special");
        }else{
            System.out.println("After");
        }
    }
}

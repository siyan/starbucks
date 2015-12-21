package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;

public class Waterloo20111 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("How many antennas?");
        int antenna = Integer.parseInt(input.nextLine());
        System.out.println("How many eyes");
        int eyes = Integer.parseInt(input.nextLine());
        if (antenna >= 3 & eyes <= 4){
            System.out.println("TroyMartian");
        }
        if (antenna <= 6 & eyes >= 2){
            System.out.println("VladSaturnian");
        }
        if (antenna <= 2 & eyes <= 3){
            System.out.println("GraemeMercurian");
        }
    }
}

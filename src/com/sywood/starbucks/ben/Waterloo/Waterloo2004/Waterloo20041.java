package com.sywood.starbucks.ben.Waterloo.Waterloo2004;
import java.util.Scanner;

public class Waterloo20041 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Number of tiles?");
        int num = input.nextInt();
        System.out.println("The largest square has side length " + (int)Math.floor(Math.sqrt(num)));
    }
}

package com.sywood.starbucks.ben;
import java.util.Scanner;

public class Waterloo20131 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int c = b + (b-a);
        System.out.print(c);
    }
}

package com.sywood.starbucks.ben;
import java.util.Scanner;


/**
 * Created by Striker on 2015-11-21.
 */
public class Waterloo2014 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int a = Integer.parseInt(input.nextLine());
        int b = Integer.parseInt(input.nextLine());
        int c = Integer.parseInt(input.nextLine());
        sum = a+b+c;
        if (sum != 180){
            System.out.print("Error");
        }else{
            if (a == b && b == c){
                System.out.print("Equilateral");
            }else if (a == b | a == c | b == c){
                System.out.print("Isoceles");
            }else{
                System.out.print("Scalene");
            }
        }

    }
}

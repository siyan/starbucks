package com.sywood.starbucks.ben.Waterloo.Waterloo2012;
import java.util.Scanner;


public class Waterloo20121 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the speed limit: ");
        int limit = input.nextInt();
        System.out.print("Enter the recorded speed of the car: ");
        int speed = input.nextInt();
        if (speed <= limit){
            System.out.print("Congratulations, you are within the speed limit!");
        }else{
            int diff = speed-limit;
            int fine = 0;
            if (diff <= 20){
                fine = 100;
            }else if (diff <= 30){
                fine = 270;
            }else{
                fine = 500;
            }
            System.out.print("You are speeding and your fine is $" + String.valueOf(fine) + ".");
        }
    }
}

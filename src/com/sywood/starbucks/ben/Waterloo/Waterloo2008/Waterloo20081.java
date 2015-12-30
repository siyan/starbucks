package com.sywood.starbucks.ben.Waterloo.Waterloo2008;
import java.util.Scanner;

public class Waterloo20081 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight: ");
        double w = input.nextInt();
        System.out.print("Enter height: ");
        double h = input.nextDouble();
        if (w/h/h > 25.0){
            System.out.print("Overweight");
        }else if (w/h/h >= 18.5 & w/h/h <= 25.0){
            System.out.print("Normal");
        }else{
            System.out.print("Underweight");
        }
    }
}

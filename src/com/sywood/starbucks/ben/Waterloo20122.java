package com.sywood.starbucks.ben;
import java.util.Scanner;

public class Waterloo20122 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num1 = Integer.parseInt(input.nextLine());
        int num2 = Integer.parseInt(input.nextLine());
        int num3 = Integer.parseInt(input.nextLine());
        int num4 = Integer.parseInt(input.nextLine());
        if (num1 == num2 & num1 == num3 & num1 == num4){
            System.out.print("Fish At Constant Depth");
        }else if (num1 > num2 & num2 > num3 & num3 > num4){
            System.out.print("Fish Diving");
        }else if (num1 < num2 & num2 < num3 & num3 < num4) {
            System.out.print("Fish Rising");
        }else{
            System.out.print("No Fish");
        }
    }
}

package com.sywood.starbucks.ben;
import java.util.Scanner;

/**
 * Created by Striker on 2015-11-21.
 */
public class Waterloo20143 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int num = Integer.parseInt(input.nextLine());
        int valA = 100;
        int valB = 100;
        for (int i = 0; i < num; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            if (a > b){
                valB -= a;
            }else if (b > a){
                valA -= b;
            }else if (b == a){
                valA -= 0;
                valB -= 0;
            }else{
                System.out.print("Error");
            }
        }
        System.out.println(valA);
        System.out.println(valB);
    }
}

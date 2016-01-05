package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class CCCDPA {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iters = input.nextInt();
        for (int i = 0; i < iters; i++) {
            int num = input.nextInt();
            int sum = 0;
            for (int j = 1; j < num; j++) {
                if (num % j == 0){
                    sum += j;
                }
            }
            if (sum == num){
                System.out.println(num + " is a perfect number");
            }else if (sum < num){
                System.out.println(num + " is a deficient number");
            }else{
                System.out.println(num + " is an abundant number");
            }
        }
    }
}

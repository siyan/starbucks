package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class CCC92S2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iters = Integer.parseInt(input.nextLine());
        for (int i = 0; i < iters; i++) {
            int num = Integer.parseInt(input.nextLine());
            int digit = num%10;
            while (num > 99){
                System.out.println(num);
                num -= digit;
                num = num/10;
                digit = num % 10;
            }
            if (num % 11 == 0){
                System.out.println("The number " + num + " is divisible by 11.");
            }else{
                System.out.println("The number " + num + " is not divisible by 11");
            }
        }
    }
}

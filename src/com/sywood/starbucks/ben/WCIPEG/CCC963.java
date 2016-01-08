package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class CCC963 {
    private static int n = 0;
    private static char[] numbers = new char[30];
    private static void shift(int pos, int ones){
        if (pos == 0 & ones == 0){
            for(int i = 0; i < n; i++){
                System.out.print(numbers[i]);
            }
            System.out.print("\n");
        }else{
            if (ones > 0){
                numbers[n - pos] = '1';
                shift(pos-1, ones-1);
            }
            if (pos > ones){
                numbers[n - pos] = '0';
                shift(pos-1, ones);
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iter = Integer.parseInt(input.nextLine());
        for (int i = 0; i < iter; i++){
            n = input.nextInt();
            int k = input.nextInt();
            System.out.println("The bit patterns are");
            shift(n, k);
        }
    }
}

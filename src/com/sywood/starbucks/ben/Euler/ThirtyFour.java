package com.sywood.starbucks.ben.Euler;

/**
 * Created by Striker on 2016-04-25.
 * I hate the default template warning
 */
public class ThirtyFour {
    private static int factorial(int num){
        if (num == 0){
            return 1;
        }else{
            int ret = 1;
            for (int i = 1; i <= num; i++) {
                ret *= i;
            }
            return ret;
        }
    }
    public static void main(String[] args){
        long[] facts = new long[10];
        for (int i = 0; i < 10; i++) {
            facts[i] = factorial(i);
        }
        long total = 0;
        for (int i = 3; i < facts[9]*7; i++) {
            long sum = 0;
            int temp = i;
            while (temp > 0){
                sum += facts[temp%10];
                temp /= 10;
                if (temp < 10){
                    sum += facts[temp];
                    temp = 0;
                }
            }
            if (sum == i){
                System.out.println(sum);
                total += i;
            }
        }
        System.out.print(total);
    }
}

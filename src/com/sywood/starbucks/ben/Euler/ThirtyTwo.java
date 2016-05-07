package com.sywood.starbucks.ben.Euler;

public class ThirtyTwo {
    private static boolean isPandigital(long num){
        if (num > 999999999 | num < 100000000){
            return false;
        }else{
            long count = 0;
            while (num > 0){
                count |= 1 << (num % 10);
                num /= 10;
            }
            return (count>>1 == (1<<9)-1 && Math.log(num) <= 9 && Math.log(num) > 8);
        }
    }
    private static long combine(int first, int second, int third){
        long temp = first;
        long ret;
        while (temp > 0){
            temp /= 10;
            second *= 10;
        }
        ret = first+second;
        temp = second;
        while (temp > 0){
            temp /= 10;
            third *= 10;
        }
        ret += third;
        return ret;
    }

    public static void main(String[] args){
        int sum = 0;
        for (int i = 1; i < 9876; i++) {
            for (int j = 1; j < 9876; j++) {
                int product = i*j;
                if (isPandigital(combine(i, j, product))){
                    sum += product;
                }
            }
        }
        System.out.println(sum);
    }
}

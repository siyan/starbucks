package com.sywood.starbucks.ben.Euler;
import java.util.ArrayList;

public class ThirtyTwo {
    private static boolean isPandigital(long num){
        if (Long.toString(num).length() != 9){
            return false;
        }else{
            long count = 0;
            while (num > 0){
                count |= 1 << (num % 10);
                num /= 10;
            }
            return (count>>1 == (1<<9)-1);
        }
    }
    private static long combine(int first, long second, long third){
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
        ArrayList<Long> pandigits = new ArrayList<>();
        for (int i = 2; i < 100; i++) {
            long start = i > 9 ? 123:1234;
            long end = 10000/i+1;
            for (long j = start; j < end; j++) {
                long product = i*j;
                if (isPandigital(combine(i, j, product)) && !pandigits.contains(combine(i, j, product))){
                    sum += product;
                    pandigits.add(product);
                }
            }
        }

        System.out.println(sum);
    }
}

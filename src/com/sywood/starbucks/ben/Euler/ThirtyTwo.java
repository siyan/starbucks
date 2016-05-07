package com.sywood.starbucks.ben.Euler;

public class ThirtyTwo {
    private static boolean isPandigital(int first, int second, int third){
        if (third < 1000){
            return false;
        }else{
            int count = 0;
            while (first > 0){
                count |= 1 << (first % 10);
                first /= 10;
            }
            while (second > 0){
                count |= 1 << (second % 10);
                second /= 10;
            }
            while (third > 0){
                count |= 1 << (third % 10);
                third /= 10;
            }
            return (count>>1 == (1<<9)-1);
        }
    }

    public static void main(String[] args){
        int sum = 0;
        for (int i = 1; i < 98; i++) {
            for (int j = 100; j < 987; j++) {
                int product = i*j;
                if (isPandigital(i, j, product)){
                    sum += product;
                }
            }
        }
        System.out.println(sum);
    }
}

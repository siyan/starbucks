package com.sywood.starbucks.ben.Euler.Twenties;

public class TwentySeven {
    static boolean isPrime(int num){
        if (num > 1) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int max = 0;
        int first = 0;
        int second = 0;
        for (int a = -999; a < 1000; a++){
            for (int b = -999; b < 1000; b++){
                int i = 0;
                while(isPrime(i*i+a*i+b)){
                    i++;
                }
                if (max < i){
                    max = i;
                    first = a;
                    second = b;
                }
            }
        }
        System.out.println(first*second);
    }
}

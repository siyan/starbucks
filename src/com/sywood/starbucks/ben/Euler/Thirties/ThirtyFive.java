package com.sywood.starbucks.ben.Euler.Thirties;
import java.util.ArrayList;

public class ThirtyFive {
    private static ArrayList<Integer> primes = new ArrayList<>();
    private static boolean isPrime(int num){
        if (primes.contains(num)){
            return true;
        }else {
            for (int i = 2; num >= i * i; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    private static void generate(){
        primes.add(2);
        for (int i = 3; i < 1000000; i++) {
            if (isPrime(i)){
                primes.add(i);
            }
        }
    }
    private static int circle (int num){
        if (num > 9) {
            String temp = Integer.toString(num);
            String other = temp.substring(1);
            other += temp.charAt(0);
            return Integer.parseInt(other);
        }else{
            return num;
        }
    }

    public static void main(String[] args){
        generate();
        int count = 0;
        for (int prime : primes){
            int temp = circle(prime);
            boolean isCircular = true;
            while (temp != prime){
                isCircular = isPrime(temp);
                temp = circle(temp);
            }
            if (isCircular){
                count++;
            }
        }
        System.out.println(count);
    }
}

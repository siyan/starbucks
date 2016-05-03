package com.sywood.starbucks.ben.Euler;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * simple brute-force solution
 */
public class ThirtySeven {
    static ArrayList<Integer> primes = new ArrayList<>();
    private static boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        if(!primes.contains(num)){
            for (int i = 2; i*i < num; i++) {
                if (num%i == 0){
                    return false;
                }
            }
            primes.add(num);
            return true;
        }else{
            return true;
        }
    }
    private static int reverse(int num){
        String reverse = "";
        String curr = String.valueOf(num);
        for (int i = curr.length()-1; i >= 0 ; i--) {
            reverse += curr.charAt(i);
        }
        return Integer.parseInt(reverse);
    }
    private static boolean truncBothWays(int num){
        if (!isPrime(num)){
            return false;
        }else{
            boolean trunc = true;
            int reverse = reverse(num);
            while (num > 0){
                trunc &= isPrime(num) && isPrime(reverse);
                num /= 10;
                reverse /= 10;
            }
            return trunc;
        }
    }


    public static void main(String[] args) {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        int found = 0;
        int sum = 0;
        for (int j = 10; j < 1000000; j++) {
            isPrime(j);
        }

        for (int prime : primes){
            if (found >= 11){
                break;
            }
            if (truncBothWays(prime) && prime != 2 && prime != 3 && prime != 7 && prime != 5){
                found++;
                sum += prime;
            }
        }
        System.out.print(sum);

    }
}

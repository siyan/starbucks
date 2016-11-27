package com.sywood.starbucks.ben.CodeForces.Round382Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 dp with prime numbers having a value of 1.
 optimal choice is to have all numbers a sum of primes
 */
public class D {
    static boolean isPrime(int n){
        if(n == 2) return true;
        for(int i = 2; i*i <= n; i++)
            if(n%i == 0) return false;
        return true;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        if(isPrime(n)) System.out.println(1);
        else if (n%2 == 0 || isPrime(n-2)) System.out.println(2);
        else if(n >= 6)System.out.println(3);
    }
}

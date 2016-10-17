package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.ArrayList;

/**
 ID: benbli
 LANG: JAVA
 TASK: sprime
 */
public class sprime {

    private static boolean isPrime(int n){
        if(n%2 == 0 && n != 2 || n == 1)return false;
        for(int i = 3; i*i <= n; i+= 2)
            if(n % i == 0)return false;
        return true;
    }

    private static boolean isSuperPrime(int n){
        while(n > 0){
            if(!isPrime(n)) return false;
            n /= 10;
        }
        return true;
    }

    private static int N;
    private static ArrayList<Integer> primes = new ArrayList<Integer>();
    private static int[] odds = new int[]{1, 3, 7, 9};
    private static void generate(String curr){
        if(curr.length() == N){
            primes.add(Integer.parseInt(curr));
        }else{
            for(int digit : odds){
                generate(curr + digit);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("sprime.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        N = Integer.parseInt(input.readLine());
        input.close();
        if (N == 1){
            printer.println(2);
            printer.println(3);
            printer.println(5);
            printer.println(7);
        }
        int[] startingDigits = new int[]{2, 3, 5, 7};

        for(int start : startingDigits){
            generate(Integer.toString(start));
        }

        for(int num : primes){
            if(isSuperPrime(num))
                printer.println(num);
        }


        printer.close();
    }
}

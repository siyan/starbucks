//package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 ID: benbli
 LANG: JAVA
 TASK: pprime
 */
public class pprime {


    private static boolean isPalindrome(int n){
        String ret = "";
        String curr = String.valueOf(n);
        for(int i = curr.length()-1; i >= 0; i--){
            ret += curr.charAt(i);
        }
        return ret.equals(curr);
    }

    private static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("pprime.in")));
        PrintWriter printer = new PrintWriter(new BufferedOutputStream(new FileOutputStream("pprime.out")));
        String[] data = input.readLine().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        input.close();

        ArrayList<Integer> palindromes = new ArrayList<Integer>();
        palindromes.add(5);
        palindromes.add(7);

        for (int i = 1; i <= 9; i++)
            palindromes.add(i * 10 + i);

        for (int i = 0; i <= 9; i++){
            for (int j = 1; j <= 9; j+= 2) {
                palindromes.add(j * 100 + i * 10 + j);
                palindromes.add(j * 1000 + i * 100 + i * 10 + j);
            }
        }

        for(int i = 0; i < 10; i ++){
            for(int j = 0; j < 10; j++){
                for(int k = 1; k < 10; k += 2){
                    palindromes.add(10000*k + 1000*j + 100*i + 10*j + k);
                    palindromes.add(100000*k + 10000*j + 1000*i + 100*i + 10*j + k);
                }
            }
        }

        for(int d0 = 0; d0 < 10; d0++){ //7-digit/8-digit palindromes
            for(int d1 = 0; d1 < 10; d1++){
                for(int d2 = 0; d2 < 10; d2++){
                    for(int d3 = 1; d3 < 10; d3 += 2){
                        palindromes.add(1000000 * d3 + 100000 * d2 + 10000 * d1 + 1000 * d0 + 100 * d1 + 10 * d2 + d3);
                        palindromes.add(10000000 * d3 + 1000000 * d2 + 100000 * d1 + 10000 * d0 + 1000 * d0 + 100 * d1 + 10 * d2 + d3);
                    }
                }
            }
        }

        Collections.sort(palindromes);

        for(int palindrome : palindromes)
            if(palindrome >= a && isPrime(palindrome) && palindrome <= b)
                printer.println(palindrome);
            else if(palindrome > b)
                break;

        printer.close();
    }
}

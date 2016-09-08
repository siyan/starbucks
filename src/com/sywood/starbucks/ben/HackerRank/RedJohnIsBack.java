package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * help y I bad
 */
public class RedJohnIsBack {

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(input.readLine());

        for(int t = 1; t <= T; t++){
            int target = Integer.parseInt(input.readLine());
            int[] memo = new int[target+1];

            for(int i = 0; i < 4 && i < target; i++)
                memo[i] = 1;

            int curr = 3;

            while(curr < target){
                memo[curr+1] = memo[curr] + memo[curr-3];
                curr++;
            }

            int max = memo[target];
            int total = 0;
            for(int i = 2; i <= max; i++){
                if (BigInteger.valueOf(i).isProbablePrime(25)) total++;
            }
            System.out.println(total);
        }

    }
}

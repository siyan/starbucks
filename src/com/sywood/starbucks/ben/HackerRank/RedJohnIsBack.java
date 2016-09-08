package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * help y I bad
 */
public class RedJohnIsBack {
    private static int target;
    private static int[] coins = new int[]{1, 4};

    private static long coinChange(){
        long[][] memo = new long[target+1][coins.length];

        Arrays.fill(memo[0], 1);
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < coins.length; j++){
                long x = i-coins[j] >= 0 ? memo[i-coins[j]][j] : 0;

                long y = j > 0 ? memo[i][j-1] : 0;
                memo[i][j] = x+y;

            }
        }
        return memo[target][coins.length-1];
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(input.readLine());

        for(int t = 1; t <= T; t++){
            target = Integer.parseInt(input.readLine());
            int total = 0;
            for(int i = 1; i <= coinChange(); i++){
                if (BigInteger.valueOf(i).isProbablePrime(90)) total++;
            }
            System.out.println(total);
        }

    }
}

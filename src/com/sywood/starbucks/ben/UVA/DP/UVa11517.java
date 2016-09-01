package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Variant of coin change, deals with min change greater than or equal to the target value
 */
public class UVa11517 {
    private static int price, target;
    private static int[] coins;

    private static long[] coinChange(){
        long memo[] = new long[30001];

        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for(int coin : coins){
            for(int value = 30001-coin-1; value >= 0; value--){
                if (memo[value] < Integer.MAX_VALUE)
                    memo[value + coin] = Math.min(memo[value+coin], memo[value]+1);
            }
        }
        for(int value = price; value <= 30000; value++){
            if (memo[value] < Integer.MAX_VALUE){
                return new long[]{value, memo[value]};
            }
        }
        return new long[]{-1, -1};
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        for(int T = 1; T <= t; T++){
            price = Integer.parseInt(input.readLine());
            int n = Integer.parseInt(input.readLine());
            coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(input.readLine());
            }
            target = price + coins[n-1];
            long[] ret = coinChange();
            System.out.println(ret[0] + " " + ret[1]);
        }
    }
}

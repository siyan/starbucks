package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Ben on 2016-08-31.
 */
public class UVa11517 {
    private static int price, target;
    private static int[] coins = new int[]{1, 5, 10, 25, 50};

    private static long[] coinChange(){
        long[][] memo = new long[coins.length+1][target+1];
        for (int i = 0; i < coins.length+1; i++)
            memo[i][0] = 1; //if the value is 0, there's one way to make 0 cents
        Arrays.fill(memo[0], 0);

        for(int i = 1; i < coins.length+1; i++) {
            for(int j = 1; j < target+1; j++){
                if (coins[i-1] <= j)
                    memo[i][j] = memo[i-1][j] + memo[i][j - coins[i-1]];
                else
                    memo[i][j] = memo[i-1][j];
            }
        }
        if (memo[coins.length][price] > 0){
            return new long[]{price, memo[coins.length][target]};
        }
        for (int i = target+1; i <= target; i++) {
            if (memo[coins.length][i] > 0){
                return new long[]{i, memo[coins.length][i]};
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
            long[] results = coinChange();
            System.out.println(results[0] + " " + results[1]);
        }
    }
}

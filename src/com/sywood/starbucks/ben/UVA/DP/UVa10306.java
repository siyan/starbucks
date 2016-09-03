package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Second underlined coin change problem
 */
public class UVa10306 {
    private static int N, target;
    private static int[] coins = new int[]{1, 5, 10, 25, 50};

    private static long coinChange(){
        long[][] memo = new long[target+1][coins.length];

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < coins.length; j++){
                if (i == 0)
                    memo[i][j] = 1;
                else if (j == 0)
                    if (i % coins[j] == 0)
                        memo[i][j] = 1;
                    else
                        memo[i][j] = 0;
                else if( coins[j] > i)
                    memo[i][j] = memo[i][j-1];
                else
                    memo[i][j] = memo[i - coins[j]][j] + memo[i][j-1];
            }
        }
        return memo[target][coins.length-1];
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = input.readLine().split(" ");
            int m = Integer.parseInt(data[0]);
            int S = Integer.parseInt(data[1]);

        }
    }
}

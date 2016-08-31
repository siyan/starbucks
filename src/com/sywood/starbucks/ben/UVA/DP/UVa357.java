package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * First underlined coin change problem
 * change
 */
public class UVa357 {
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
        String line = input.readLine();
        while(line != null && !line.equals("")){
            target = Integer.parseInt(line);
            long ways = coinChange();
            if (ways == 1)
                System.out.println("There is only 1 way to produce " + target + " cents change.");
            else
                System.out.println("There are " + ways + " ways to produce " + target + " cents change.");
            line = input.readLine();
        }
    }
}

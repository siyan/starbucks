package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * First underlined coin change problem
 */
public class UVa357 {
    private static int N, target;
    private static int[] coins = new int[]{1, 5, 10, 25, 50};

    private static long coinChange(){
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
        return memo[coins.length][target];
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

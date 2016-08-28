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

    private static int coinChange(int currentValue, int idx){
        int[][] memo = new int[coins.length+1][currentValue+1];
        Arrays.fill(memo[0], 0);
        for (int i = 0; i < coins.length+1; i++) {
            memo[i][0] = 1; //if the value is 0, there's one way to make 0 cents
        }
        return 0;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while(line != null && !line.equals("")){
            int n = Integer.parseInt(line);
            int ways = coinChange(n, 5);
            if (ways == 1)
                System.out.println("There are " + ways + " to produce " + n + " cents change.");
            else
                System.out.println("There are " + ways + " to produce " + n + " cents change.");
            line = input.readLine();
        }
    }
}

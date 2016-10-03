package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-10-02.
 */
public class ABA12C {
    private static int[] weights;
    private static int[] values;
    private static int money, n;
    private static int knapsack() {
        int[][] memo = new int[n+1][money+1];

        for(int i = 0; i <= n; i++){
            for(int weight = 0; weight <= money; weight++){
                if(i == 0 || weight == 0)
                    memo[i][weight] = 0;
                else if (weights[i-1] <= weight)
                    memo[i][weight] = Math.max(values[i-1] + memo[i-1][weight-weights[i-1]], memo[i-1][weight]);
                else
                    memo[i][weight] = memo[i-1][weight];
            }
        }

        return memo[n][money];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(input.readLine());
        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);
        int[] memo = new int[K];
        int[] prices = new int[K];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < K; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            if (prices[i] > -1){

            }
        }
    }
}

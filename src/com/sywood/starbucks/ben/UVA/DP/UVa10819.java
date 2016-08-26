package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa10819 {
    private static int[] weights = new int[0];
    private static int[] values = new int[0];
    private static int[][] memo;
    private static int money;
    private static int knapsack(int idx, int W) {
        if (W > money && money < 1800) //solution doesn't work
            return -1000;
        if (W > money + 200) // solution doesn't work
            return -1000;
        if (idx == weights.length) {
            if (W > money && W <= 2000) // solution doesn't work
                return -1000;
            return 0;
        }

        if(memo[idx][W] != -1)
            return memo[idx][W];
        return memo[idx][W] = Math.max(knapsack(idx+1, W), knapsack(idx+1, W + weights[idx]) + values[idx]);

    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        StringTokenizer st;
        while(line != null && !line.equals("")){
            st = new StringTokenizer(line);
            money = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (money > 2000)
                money += 200;
            weights = new int[n];
            values = new int[n];
            memo = new int[110][15000];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            for (int i = 0; i < n; i++) {
                String[] data = input.readLine().split(" ");
                weights[i] = Integer.parseInt(data[0]);
                values[i] = Integer.parseInt(data[1]);
            }
            System.out.println(knapsack(0, 0));
            line = input.readLine();
        }
    }
}

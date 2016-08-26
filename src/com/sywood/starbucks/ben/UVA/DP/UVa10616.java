package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * knapsack first underlined problem
 */
public class UVa10616 {
    private static int[] values;
    private static int N, D, M;
    private static int[][][] memo;
    private static int knapsack(int index, int weight, int sum) {
        sum = (sum%D + D)%D;
        if (weight == M && sum == 0) //last item, and is divisible by D
            return 1;
        if (weight == M) //picked max number of items
            return 0;
        if (index == N) //last item
            return 0;

        if (memo[index][weight][sum] != -1)
            return memo[index][weight][sum];

        return memo[index][weight][sum] = knapsack(index+1, weight+1, (sum + values[index])%D) + knapsack(index+1, weight, sum);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        StringTokenizer st;
        int set = 1;
        while(!line.equals("0 0")) {
            System.out.println("SET " + set + ":");
            st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            values = new int[N];

            for (int i = 0; i < N; i++)
                values[i] = Integer.parseInt(input.readLine());

            for (int q = 1; q <= Q; q++) {
                st = new StringTokenizer(input.readLine());
                D = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                memo = new int[200][10][25];
                for (int i = 0; i < 200; i++) {
                    for (int j = 0; j < 10; j++) {
                        Arrays.fill(memo[i][j], -1);
                    }
                }
                System.out.println("QUERY " + q +": " + knapsack(0, 0, 0));
            }
            line = input.readLine();
            set++;
        }
    }
}

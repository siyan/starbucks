package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa10819 {
    private static int[] weights;
    private static int[] values;
    private static int[][] memo;
    private static int money, n;
    private static int knapsack(int idx, int spent) {
        if (spent > money && money < 1800)
            return -1000; //can't trigger credit
        if (spent > money + 200)
            return -1000; //spent too much
        if (idx == n && spent > money && spent <= 2000)
            return -1000; //can't trigger credit limit because at end
        if(idx == n) return 0; //made it to the end!
        if(memo[idx][spent] != -1)
            return memo[idx][spent];

        return memo[idx][spent] = Math.max(knapsack(idx+1, spent), knapsack(idx+1, spent + weights[idx]) + values[idx]);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        StringTokenizer st;
        while(line != null && !line.equals("")){
            st = new StringTokenizer(line);

            money = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            weights = new int[n];
            values = new int[n];
            memo = new int[110][15000];
            for (int i = 0; i < 101; i++) {
                Arrays.fill(memo[i], -1);
            }
            for (int i = 0; i < n; i++) {
                String[] data = input.readLine().split(" ");
                weights[i] = Integer.parseInt(data[0]);
                values[i] = Integer.parseInt(data[1]);
            }

            printer.println(knapsack(0, 0));
            line = input.readLine();
        }
        printer.close();
    }
}

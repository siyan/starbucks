package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Final underlined knapsack question
 */
public class UVa11566 {
    private static int[] weights;
    private static double[] values;
    private static double[][] memo;
    private static int N, x, T, K;
    private static double knapsack(int idx, int spent, int dishesTaken) {
        if (Math.ceil((spent+T)*1.1) > x || dishesTaken > 2*(N+1) || spent > x )
            return -1000; //spent too much, or took too many dishes
        if(idx == K*2 )
            return 0; //made it to the end
        if(memo[idx][spent] != -1)
            return memo[idx][spent];

        double d1 = knapsack(idx+1, spent, dishesTaken);
        double d2 = knapsack(idx, spent + weights[idx], dishesTaken+1);
        return memo[idx][spent] = Math.max(d1 ,  d2 + values[idx]);
    }



   public static void main(String[] args)throws Exception{
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       String line = input.readLine();
       StringTokenizer st;
       while(!line.equals("0 0 0 0")){
           st = new StringTokenizer(line);
           N = Integer.parseInt(st.nextToken());
           x = Integer.parseInt(st.nextToken())*(N+1);
           T = Integer.parseInt(st.nextToken())*(N+1);
           //x -= T;
           K = Integer.parseInt(st.nextToken());
           weights = new int[2*K];
           values = new double[2*K];
           memo = new double[K*2][x+1];
           for (int i = 0; i < K*2; i++) {
               Arrays.fill(memo[i], -1);
           }

           for (int i = 0; i < K; i++) {
               st = new StringTokenizer(input.readLine());
               weights[i] = Integer.parseInt(st.nextToken());
               weights[K+i] = weights[i];
               for (int j = 0; j <= N; j++) {
                   values[i] += Integer.parseInt(st.nextToken());
               }
               values[K+i] = values[i];
           }
           System.out.printf("%.02f\n", (knapsack(0, 0, 0)/(N+1)));
           line = input.readLine();
       }
   }
}
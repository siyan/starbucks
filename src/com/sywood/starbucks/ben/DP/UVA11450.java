package com.sywood.starbucks.ben.DP;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.io.*;

public class UVA11450 {
    private static int[][] prices = new int[25][25];
    private static int M = 0;
    private static int C = 0;
    private static int[][] memoize = new int[210][25];

    private static int shop(int m, int layer){
        if (m < 0){
            return -1000000;
        } else if (layer == C) {
            return M - m;
        }else{
            if (memoize[m][layer] != 0){
                return memoize[m][layer];
            }
            int max = 0;
            for (int i = 0; i < prices[layer].length; i++) {
                max = Math.max(max, shop(m - prices[layer][i], layer+1));
            }
            memoize[m][layer] = max;
            return memoize[m][layer];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(input.readLine());
        for (int i = 0; i < iter; i++) {
            String[] use = input.readLine().split(" ");
            M = Integer.parseInt(use[0]);
            C = Integer.parseInt(use[1]);
            for (int j = 0; j < C; j++) {
                String[] garments = input.readLine().split(" ");
                int numG = Integer.parseInt(garments[0]);
                for (int k = 1; k <= numG; k++) {
                    prices[j][k-1] = Integer.parseInt(garments[k]);
                }
            }
            int shopped = shop(M, 0);
            if (shopped > 0){
                System.out.println(shopped);
            }else{System.out.println("no solution");}
        }
    }
}

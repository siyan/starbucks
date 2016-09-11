package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-09-10.
 */
public class LCSReturns {
    static int lcs(char[] x, char[] y){
        int[][] memo = new int[x.length][y.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else if (x[i-1] == y[j-1])
                    memo[i][j] = memo[i-1][j-1];
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }
        return memo[x.length][y.length];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String a = input.readLine();
        String b = input.readLine();


    }
}

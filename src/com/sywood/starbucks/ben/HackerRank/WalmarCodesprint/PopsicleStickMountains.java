package com.sywood.starbucks.ben.HackerRank.WalmarCodesprint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PopsicleStickMountains {
    private static long[] memo = new long[4001];

    private static long[] factorial = new long[4001];


    private static long catalan(int n) {
        long res = 0;

        // Base case
        if (n <= 1) {
            return 1;
        }
        if(memo[n] != -1)
            return memo[n];
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        return memo[n] = res;
    }



    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(memo, -1);
        memo[0] = 1;
        Arrays.fill(factorial, -1);
        int N = Integer.parseInt(input.readLine());
        int t;
        for (int i = 0; i < N; i++) {
            t = Integer.parseInt(input.readLine())/2;
            //calculate(t);
            long sum = 0;
            for(int j = 1; j <= t; j++) {
                sum += catalan(j);
                sum %= 1000000007;
            }
            System.out.println(sum);
        }

    }
}

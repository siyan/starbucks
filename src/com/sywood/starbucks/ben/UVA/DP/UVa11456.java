package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * underlined longest increasing subsequence problem
 */
public class UVa11456 {

    private static int both(int[] input) {
        int[] dm = new int[input.length];
        int[] lm = new int[input.length];
        Arrays.fill(dm, 1);
        Arrays.fill(lm, 1);
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dm[i] <= dm[j] && input[i] > input[j]) {
                    dm[i] = dm[j]+1;
                }
                if (lm[i] <= lm[j] && input[i] < input[j]) {
                    lm[i] = lm[j]+1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            max = Math.max(dm[i]+lm[i]-1, max);
        }
        return max;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(input.readLine());
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input.readLine());
            }
            System.out.println(both(nums));
        }
    }
}

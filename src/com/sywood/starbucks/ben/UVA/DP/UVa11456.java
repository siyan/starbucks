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
        for (int x = input.length-2; x >= 0; x--) {
            for (int y = input.length-1; y > x; y--) {
                if (dm[x] <= dm[y] && input[x] > input[y]) {
                    dm[x] = dm[y]+1;
                }
                if (lm[x] <= lm[y] && input[x] < input[y]) {
                    lm[x] = lm[y]+1;
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

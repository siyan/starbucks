package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-06.
 */
public class MaximumSubarray {
    public static int[] kadaneSum(int[] a) {
        //result[0] == maxSum, result[1] == start, result[2] == end;
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                currentSum = 0;
                localStart = i + 1;
            } else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
            }
        }

        //all numbers in a are negative
        if (result[2] == -1) {

            for (int i = 0; i < a.length; i++) {
                if (a[i] > result[0]) {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }

        return result;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine().trim());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(input.readLine().trim());
            StringTokenizer st = new StringTokenizer(input.readLine());
            int[] numbers = new int[n];
            int total = 0;
            boolean allNegative = true;
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
                if (numbers[i] >= 0){
                    total += numbers[i];
                    allNegative &= numbers[i] < 0;
                }
            }

            if(allNegative){
                total = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    total = Math.max(total, numbers[i]);
                }
            }
            System.out.println(kadaneSum(numbers)[0] + " " + total);
        }
    }
}

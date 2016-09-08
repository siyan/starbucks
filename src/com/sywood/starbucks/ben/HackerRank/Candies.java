package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Ben on 2016-09-06.
 */
public class Candies {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine().trim());
        long[] values = new long[N];
        for (int i = 0; i < N; i++) {
            values[i] = Long.parseLong(input.readLine().trim());
        }
        long min = 0;
        int[] given = new int[N];
        Arrays.fill(given, 1);
        for(int i = 1; i < N-1; i++){
            if(values[i-1] < values[i])
                given[i] = given[i-1]+1;
        }
        for(int i = N-2; i >= 0; i--) {
            if (values[i] > values[i + 1])
                given[i] = Math.max(given[i], given[i + 1] + 1);
        }
        for(int candy : given)
            min += candy;
        System.out.println(min);
    }
}

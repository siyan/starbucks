package com.sywood.starbucks.ben.Waterloo.Waterloo2002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Ben on 2016-11-16.
 */
public class ccc0204 {
    private static int M;
    private static int Q;
    private static int[]times;
    private static int[] memo;
    private static int[] sizes;
    static int max(int a , int b){
        return a > b ? a : b;
    }

    public static int recurse(int currSize, int groupT, int totalT, int idx){
        System.out.println(idx + ", " + currSize + ", " + groupT + ", " + totalT);
        if(idx == Q) return totalT+groupT;

        if(memo[idx] != -1)
            return memo[idx];

        if(currSize == M)
            return memo[idx] = recurse(0, 0, totalT+groupT, idx+1); //have to send the group

        if(currSize == 0)
            return memo[idx] = recurse(1, times[idx], totalT, idx+1); //must take the next person

        return memo[idx] = max(recurse(0, 0, totalT+groupT, idx+1), recurse(currSize+1, max(groupT, times[idx]), totalT, idx+1));
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(input.readLine());
        Q = Integer.parseInt(input.readLine());
        String[] names = new String[Q];
        times = new int[Q];
        memo = new int[Q];
        sizes = new int[Q];
        for (int i = 0; i < Q; i++) {
            names[i] = input.readLine();
            times[i] = Integer.parseInt(input.readLine());
            memo[i] = -1;
        }
        //two options: take new person, or send group and start once more.
        System.out.println("Total Time: " + recurse(0, 0, 0, 0));
        System.out.println(Arrays.toString(memo));
    }
}
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
    static int min(int a, int b){
        return a > b ? b : a;
    }

    public static int recurse(int currSize, int groupT, int totalT, int idx){
        System.out.println(idx + ", size: " + currSize + ", group time: " + groupT + ", tot time: " + totalT);
        if(idx == Q){
            if(currSize == 1)
                return totalT + times[idx-1];

            sizes[Q-currSize] = currSize;
            return totalT+groupT;
        }

        if(memo[idx] != -1)
            return memo[idx];

        if(currSize == M) {
            System.out.println("YES");
            sizes[idx] = M;
            return memo[idx] = recurse(1, times[idx], totalT + groupT, idx + 1); //have to send the group
        }
        if(currSize == 0)
            return memo[idx] = recurse(1, times[idx], totalT, idx+1); //must take the next person

        int sent = recurse(1, times[idx], totalT+groupT, idx+1);
        int not = recurse(currSize+1, max(groupT, times[idx]), totalT, idx+1);

        if(sent < not){
            sizes[idx] = currSize;
        }

        return memo[idx] = min(sent, not);
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
            sizes[i] = 1;
        }
        //two options: take new person, or send group and start once more.
        System.out.println("Total Time: " + recurse(1, times[0], 0, 1));

        System.out.println(Arrays.toString(sizes));
        for (int i = 0; i < Q; i+= sizes[i]) {
            String prnt = "";
            for (int j = 0; j < sizes[i] && j+i < Q; j++) {
                prnt += names[i+j] + " ";
            }
            System.out.println(prnt.trim());
        }
    }
}
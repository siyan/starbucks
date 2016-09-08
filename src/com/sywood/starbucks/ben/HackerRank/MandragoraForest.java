package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-06.
 */
public class MandragoraForest {
    static long[] weights;

    static long run(){
        long answer = 0;
        long runningSum = 0;
        for(int i = weights.length-1; i >= 0; i--){ //how many are eaten
            runningSum += weights[i];
            answer = Math.max(answer, runningSum*(i+1));
        }
        return answer;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(input.readLine());
        for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(input.readLine());
            weights = new long[n];
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                weights[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(weights);
            System.out.println(run());
        }
    }
}

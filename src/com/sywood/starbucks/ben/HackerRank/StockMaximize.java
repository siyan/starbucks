package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-10.
 */
public class StockMaximize {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(input.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(input.readLine());

            int[] values = new int[N];
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }
            long total = 0;
            long currMax = 0;
            for(int i = N-1; i >= 0; i--){
                currMax = Math.max(currMax, values[i]);

                total += currMax - values[i];
            }
            System.out.println(total);
        }
    }
}

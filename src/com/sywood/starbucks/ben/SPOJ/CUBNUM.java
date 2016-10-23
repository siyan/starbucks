package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CUBNUM {

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        int n;
        int tCase = 1;
        int[] memo = new int[200001];
        memo[0] = 0;
        for(int curr = 1; curr <= 200000; curr++){
                int best = Integer.MAX_VALUE;
                for(int i = 1; i*i*i <= curr; i++){
                    best = Math.min(best, memo[curr-i*i*i]+1);
                }
                memo[curr] = best;
            }
        while(line != null && !line.equals("")){
            n = Integer.parseInt(line);


            printer.println("Case #" + tCase++ + ": " + memo[n]);
            line = input.readLine();
        }

        printer.close();
    }
}

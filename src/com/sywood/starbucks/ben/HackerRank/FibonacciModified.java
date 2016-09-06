package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-06.
 */
public class FibonacciModified {


    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        BigInteger first = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        BigInteger second = BigInteger.valueOf(Integer.parseInt(st.nextToken()));

        BigInteger[] memo;
        int n = Integer.parseInt(st.nextToken());
        memo = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            memo[i] = BigInteger.valueOf(-1);
        }
        memo[0] = first;
        memo[1] = second;

        for(int i = 2; i < n; i++)
            memo[i] = memo[i-1].multiply(memo[i-1]).add(memo[i-2]);

        System.out.println(memo[n-1]);
    }
}

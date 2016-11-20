package com.sywood.starbucks.ben.Dmoj.TLENov2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-11-17.
 */
public class P4 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        int min = N < M ? N : M;
        if(min == 1) System.out.println("First");
        else if(N == M)System.out.println("Second");
        else if (M%2 == 1 && N % 2 == 0 || M % 2 == 0 && N % 2 == 1) System.out.println("First");
        else if(M%2 == 0 && N%2 == 0) System.out.println("Second");
        else System.out.println("Second");
    }
}

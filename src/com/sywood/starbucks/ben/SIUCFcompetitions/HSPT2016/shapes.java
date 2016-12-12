package com.sywood.starbucks.ben.SIUCFcompetitions.HSPT2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Ben on 2016-12-10.
 */
public class shapes {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 1; i <= n; i++) {
            int m = Integer.parseInt(input.readLine());
            System.out.print("Shape #" + i + ": ");
            if(m > 4) System.out.println("Johnny will not be pleased with this one.");
            else System.out.println("Johnny's favorite!");
        }
    }
}

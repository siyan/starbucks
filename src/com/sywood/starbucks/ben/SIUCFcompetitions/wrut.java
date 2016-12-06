package com.sywood.starbucks.ben.SIUCFcompetitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-12-03.
 */
public class wrut {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = input.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            int c = Integer.parseInt(data[2]);
            if(a + b == c)
                System.out.println("Correct!");
            else
                System.out.println("Wrut Row!");
        }
    }
}

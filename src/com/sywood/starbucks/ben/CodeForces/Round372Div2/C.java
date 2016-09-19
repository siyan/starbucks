package com.sywood.starbucks.ben.CodeForces.Round372Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Ben on 2016-09-17.
 */
public class C {
    public static void main(String[] arg)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine())+1;

        for (long i = 1; i < n; i++) {
            if (i == 1)
                System.out.println(2);
            else
                System.out.println((i*(i+1)*(i+1)-(i-1)));
        }
    }
}

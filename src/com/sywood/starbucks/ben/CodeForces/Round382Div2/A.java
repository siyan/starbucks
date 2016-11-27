package com.sywood.starbucks.ben.CodeForces.Round382Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 Actually problem C
 */
public class A {

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(input.readLine());
        long n1 = 1, n2 = 1;
        int counter = 0;
        while(n2 <= n){
            n2 = n1 + (n1=n2);
            counter++;
        }
        System.out.println(counter-1);
    }
}

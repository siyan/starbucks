package com.sywood.starbucks.ben.CodeForces.Round365Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-04.
 */
public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        int aWins = 0;
        int bWins = 0;

        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b){
                aWins++;
            }else if (b > a){
                bWins++;
            }
        }

        if (aWins > bWins){
            printer.println("Mishka");
        }else if (bWins > aWins){
            printer.println("Chris");
        }else{
            printer.println("Friendship is magic!^^");
        }

        printer.close();
    }
}

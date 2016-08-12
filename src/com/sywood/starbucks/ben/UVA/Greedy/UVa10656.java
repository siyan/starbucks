package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * first non-classical greedy
 */
public class UVa10656 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        int current;
        String ret;
        while(N != 0){
            ret = "";
            for (int i = 0; i < N; i++) {
                current = Integer.parseInt(input.readLine());
                if (current > 0){
                    ret += current + " ";
                }
            }
            printer.println(ret.trim());
        }
        printer.close();
    }
}

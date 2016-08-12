package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Second underlined non-classical greedy problem
 */
public class UVa10718 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line = input.readLine();
        int N, L, U, optimal;//l is lower and U is upper
        while(line != null && !line.equals("")){
            st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            U = Integer.parseInt(st.nextToken());
            optimal = N^U;
            printer.println(optimal);
            line = input.readLine();
        }
        printer.close();
    }
}

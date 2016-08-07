package com.sywood.starbucks.ben.CodeForces.Round365Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long sum = 0;
        long total = 0;

        int[] values = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            sum += values[i];
        }

        int[] capitals = new int[k];
        boolean[] isCapital = new boolean[n];
        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < k; i++) {
            capitals[i] = Integer.parseInt(st.nextToken())-1;
            isCapital[capitals[i]] = true;
            total += values[capitals[i]]*(sum - values[capitals[i]]);
            sum -= values[capitals[i]];
        }

        for (int i = 0; i < n-1; i++) {
            if (!isCapital[i] && !isCapital[i+1]){
                total += values[i]*values[i+1];
            }
        }

        if (!isCapital[0] && !isCapital[n-1]){
            total += values[0]*values[n-1];
        }

        printer.println(total);

        printer.close();
    }
}

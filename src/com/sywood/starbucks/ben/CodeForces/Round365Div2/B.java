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

        int[] values = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[] capitals = new int[k];
        boolean[] isCapital = new boolean[n];
        boolean[] used = new boolean[n];
        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < k; i++) {
            capitals[i] = Integer.parseInt(st.nextToken())-1;
            isCapital[capitals[i]] = true;
        }
        long total = values[n-1]*values[0];
        for (int i = 0; i < n - 1; i++) {
            total += values[i]*values[i+1];
            if (isCapital[i]){
                used[i] = true;
                for (int j = 0; j < i-1; j++) {
                    if(!isCapital[j] || !used[j]) {
                        total += values[i] * values[j];
                        used[j] = true;
                    }
                }
                if (i == 0) {
                    for (int j = i + 2; j < n - 1; j++) {
                        if (!isCapital[j] || !used[j]) {
                            total += values[i] * values[j];
                            used[j] = true;
                        }
                    }
                }else{
                    for(int j = i+2; j < n; j++){
                        if (!isCapital[j] || !used[j]) {
                            total += values[i] * values[j];
                            used[j] = true;
                        }
                    }
                }
            }
        }

        if(isCapital[n-1]){
            for(int j = 1; j < n-1; j++){
                if(!isCapital[j] || !used[j]) {
                    total += values[n - 1] * values[j];
                }
            }
        }

        printer.println(total);
        printer.close();
    }
}

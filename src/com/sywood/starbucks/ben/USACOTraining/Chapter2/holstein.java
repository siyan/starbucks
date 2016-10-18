package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: holstien
 */
public class holstein {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        int V = Integer.parseInt(input.readLine());

        int[] weights = new int[V];

        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < V; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int numScoops = Integer.parseInt(input.readLine());



        printer.close();
    }
}

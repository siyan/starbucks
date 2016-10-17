package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 ID: benbli
 LANG: JAVA
 TASK: sort3
 */
public class sort3 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        int N = Integer.parseInt(input.readLine());

        int[] records = new int[N];
        int[] counter = new int[3];
        for (int i = 0; i < N; i++) {
            records[i] = Integer.parseInt(input.readLine());
            counter[records[i]-1]++;
        }
        printer.println(Arrays.toString(counter));

        printer.close();
    }
}

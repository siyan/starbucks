package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.Arrays;

/**
 ID: benbli
 LANG: JAVA
 TASK: sort3
 */
public class sort3 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("sort3.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        int N = Integer.parseInt(input.readLine());

        int[] records = new int[N];
        int[] counter = new int[3];
        for (int i = 0; i < N; i++) {
            records[i] = Integer.parseInt(input.readLine());
            counter[records[i]-1]++;
        }
        int[] sorted = new int[N];
        boolean[] outOfPlace = new boolean[N];
        for (int i = 0; i < counter[0]; i++) {
            sorted[i] = 1;
        }
        for(int i = counter[0]; i-counter[0] < counter[1]; i++) {
            sorted[i] = 2;
        }for(int i = counter[1]+ counter[0]; i < N; i++) {
            sorted[i] = 3;
        }

        int moves = 0;
        for(int i = 0; i < N; i ++){ //checks each idx
            if(sorted[i] != records[i]){
                for(int j = N-1; j > i; j--){
                    if(records[j] == sorted[i]){
                        records[j] = records[i];
                        records[i] = sorted[i];
                        moves++;
                        break;
                    }
                }
            }
        }

        printer.println(moves);
        printer.close();
    }
}

package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: numtri
 */
public class numtri {

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("numtri.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        int R = Integer.parseInt(input.readLine());
        int[][] memo = new int[R][R];

        StringTokenizer st;
        for (int i = 1; i <= R; i++) {

            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < i; j++) {
                memo[i-1][j] = Integer.parseInt(st.nextToken());
            }

        }
        input.close();
        int left, right, best = 0;
        for (int row = 1; row < R; row++) {
            for (int col = 0; col < R; col++) {
                if(col == 0)
                    left = memo[row-1][col];
                else
                    left = memo[row-1][col-1];


                right = memo[row-1][col];
                memo[row][col] += Math.max(left, right);

            }
        }

        for (int i = 0; i < R; i++) {
            best = Math.max(best, memo[R-1][i]);
        }
        printer.println(best);
        printer.close();

    }
}

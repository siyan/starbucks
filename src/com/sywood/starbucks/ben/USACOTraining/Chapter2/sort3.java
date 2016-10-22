package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.Scanner;

/**
 ID: benbli
 LANG: JAVA
 TASK: sort3
 */

public class sort3 {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int N = sc.nextInt();

        int[] board = new int[N];

        for(int i = 0; i < N;i++)
        {
            board[i] = sc.nextInt();

        }
        out.println(run(board));
        out.close();
    }
    public static int run(int[] board)
    {
        int N = board.length;
        int[] cor = new int[N];
        int onec = 0;
        int twoc = 0;
        for(int i = 0; i < N;i++)
        {
            if(board[i] == 1) onec++;
            if(board[i] == 2) twoc++;
        }
        for(int i = 0; i < N;i++)
        {
            if(i < onec) cor[i] = 1;
            else if(i < onec+twoc) cor[i] = 2;
            else cor[i] = 3;
        }
        int i12 = 0;
        int i21 = 0;
        int i13 = 0;
        int i31 = 0;
        int i23 = 0;
        int i32 = 0;
        for(int i = 0; i < N;i++)
        {
            if(board[i] == 1&& cor[i] == 2) i12++;
            if(board[i] == 2&& cor[i] == 1) i21++;

            if(board[i] == 1&& cor[i] == 3) i13++;
            if(board[i] == 3&& cor[i] == 1) i31++;

            if(board[i] == 2&& cor[i] == 3) i23++;
            if(board[i] == 3&& cor[i] == 2) i32++;
        }
        int moves = Math.min(i12,i21)+Math.min(i13,i31)+Math.min(i23,i32)+2*(Math.max(i12,i21)-Math.min(i12,i21));

        return moves;
    }
}

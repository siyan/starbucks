package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 ID: benbli
 LANG: JAVA
 TASK: castle
 */
public class castle {
    private static int[] dr = new int[]{1, -1, 0, 0}; // 4 directions
    private static int[] dc = new int[]{0, 0, 1, -1}; //4 directions

    private static int R, C;
    private static char[][] colours;

    private static int floodfill(int row, int col, char c1, char c2) {
        if (row < 0 || row >= R)
            return 0;

        if (colours[row][col] != c1)
            return 0; //exited the boundaries of the colour

        int ans = 1;
        colours[row][col] = c2;

        for(int d = 0; d < 8; d++)
            ans += floodfill(row + dr[d], col + dc[d], c1, c2);
        return ans;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        printer.close();
    }
}

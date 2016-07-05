package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class UVa10102 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (line != null){
            int M = Integer.parseInt(line);
            int[][] grid = new int[M][M];
            for (int i = 0; i < M; i++) {
                String row = input.readLine();
                for (int j = 0; j < row.length(); j++) {
                    grid[i][j] = row.charAt(j) - 48;
                }
            }

        }
    }
}

package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cco14troyangles {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        boolean matrix[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] data = input.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = data[j] == '#' ;
            }
        }

    }
}

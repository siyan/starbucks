package com.sywood.starbucks.ben.CodeForces.EducationalRound16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[][] matrix = new int[n][n];
        int r = 0, c = n/2;
        for(int i = 1; i <= n*n; i++) {
            System.out.println(r + ", " + c);
            if (matrix[r][c] != 0) {
                r = ((r+1)%n+1)%n;
                c = (c-1+n)%n;
            }
            matrix[r][c] = i;
            r = (r-1+n)%n;
            c = (c+1)%n;
            for(int[] row : matrix)
                System.out.println(Arrays.toString(row));
            System.out.println();
        }
    }
}
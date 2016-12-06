package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-11-27.
 */
public class ASSIGN {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(input.readLine());
        for(int C = 1; C <= c; C++){
            int n = Integer.parseInt(input.readLine());
            boolean[][] matrix = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String[] data = input.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    if(data[j].equals("1")) matrix[i][j] = true;
                    else matrix[i][j] = false;
                }
            }
        }
    }
}

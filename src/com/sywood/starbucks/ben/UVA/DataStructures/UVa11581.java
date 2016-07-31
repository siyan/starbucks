package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Third underlined 2D array problem
 */
public class UVa11581 {
    private static int f(int i){
        if (i == 0){
            return 3;
        }else{
            return 0;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        int T = Integer.parseInt(input.readLine());
        int[][] array = new int[3][3];
        for (int i = 0; i < T; i++) {
            input.readLine();
            //help me
        }
    }
}

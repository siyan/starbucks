package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * first Underlined bit operations - unfinished, array is too small, max. store size is 2^15 using current logic, sums are wrong, etc.
 */
public class UVa10264 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        while(line != null && !line.equals("")){
            int n = Integer.parseInt(line);
            int size = 2<<n;
            short[] values = new short[size];

            for (int i = 0; i < size; i++) {
                values[i] = (short) Integer.parseInt(input.readLine());
            }

            int[] sums = new int[size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < n; j++) {
                    int idx = i+(2<<j);
                    idx %= size;
                    sums[i] += values[idx];
                }
            }
            int max = 0;
            int maxt = 0;
            for (int i = 0; i < size; i++) {
                if (sums[i] > max){
                    maxt = max;
                    max = sums[i];
                }
            }
            printer.println(max+maxt);
            line = input.readLine();
        }
        printer.close();
    }
}

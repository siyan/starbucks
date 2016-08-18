package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * Second dp 2d max range sum question
 *
 * TODO: finish
 */
public class UVa836 {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i){
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if (st.hasMoreTokens()){
                return st.nextToken();
            }else{
                st = new StringTokenizer(br.readLine());
            }
            return next();
        }
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        public String readLine() throws IOException{
            return br.readLine();
        }
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        PrintWriter printer = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        String line;
        for (int i = 0; i < T; i++) {
            input.readLine();
            line = input.readLine();
            int size = line.length(), sum;
            int maxSize = 0;
            int[][] data = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    data[j][k] = line.charAt(k) - '0';
                }
                line = input.readLine();
            }
            int[][] runningSum = new int[size+1][size+1];
            for(int row = 0; row <= size; row++){
                for(int col = 0; col <= size; col++){
                    if (row == 0 || col == 0)
                        runningSum[row][col] = 0;
                    else{
                        runningSum[row][col] = runningSum[row-1][col] + runningSum[row][col-1] - runningSum[row-1][col-1] + data[row-1][col-1];
                    }
                }
            }
            for(int startRow = 0; startRow < size; startRow++){
                for(int startCol = 0; startCol < size; startCol++){
                    for(int endRow = startRow; endRow < size; endRow++){
                        for(int endCol = startCol; endCol < size; endCol++){
                            size = (endRow - startRow +1)*(endCol - startCol +1);
                            sum = runningSum[endRow+1][endCol+1] - runningSum[startRow][endCol+1] - runningSum[endRow+1][startCol] + runningSum[startRow][startCol];
                            if (sum == size){
                                maxSize = Math.max(size, maxSize);
                            }
                        }
                    }
                }
            }
            printer.println(maxSize);
            if (i != T-1){
                printer.println();
            }
        }
        printer.close();
    }
}
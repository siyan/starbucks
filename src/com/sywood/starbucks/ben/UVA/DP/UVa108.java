package com.sywood.starbucks.ben.UVA.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * first 2d range sum question
 *
 * Complexity: O(n^4)
 */


public class UVa108 {
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
        public byte nextByte() throws IOException{
            return Byte.parseByte(next());
        }
        public String readLine() throws IOException{
            return br.readLine();
        }
    }
    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        while(line != null && !line.equals("")) {
            int N = Integer.parseInt(line);

            byte[][] values = new byte[N+1][N+1]; // cumulative sum array
            int best = -127 * 100 * 100, temp;

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    values[i][j] = input.nextByte();
                    values[i][j] += values[i-1][j];
                }
            }



            line = input.readLine();
        }
        printer.close();
    }
}

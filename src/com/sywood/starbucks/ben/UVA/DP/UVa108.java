package com.sywood.starbucks.ben.UVA.DP;

import java.io.*;
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

            int[][] colPrefixSum = new int[N+1][N+1]; // prefix sum for each column
            long best = -127 * 100 * 100, subRect;

            for(int i = 0; i < N; i++) for (int j = 0; j< N; j++){
                colPrefixSum[i][j] = input.nextByte();
                if(i > 0) colPrefixSum[i][j] += colPrefixSum[i-1][j];
                if (j > 0) colPrefixSum[i][j] += colPrefixSum[i][j-1];
                if (i > 0 && j > 0) colPrefixSum[i][j] -= colPrefixSum[i-1][j-1];
            }

            for(int i = 0; i < N; i++) for (int j = 0; j < N; j++)
                for (int k = i; k < N; k++) for (int L = j; L < N; L++){
                    subRect = colPrefixSum[k][L];
                    if (i > 0) subRect -= colPrefixSum[i-1][L];
                    if (j > 0) subRect -= colPrefixSum[k][j-1];
                    if (i > 0 && j > 0) subRect += colPrefixSum[i-1][j-1];
                    best = Math.max(subRect, best);
                }

            printer.println(best);
            line = input.readLine();
        }
        printer.close();
    }
}

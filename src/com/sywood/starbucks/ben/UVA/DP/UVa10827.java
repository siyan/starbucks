package com.sywood.starbucks.ben.UVA.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Second underline UVa 2D dp question
 */
public class UVa10827 {
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
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(input.readLine().trim());

            int[][] colPrefixSum = new int[N][N*2]; // prefix sum for each column
            long best = -100*N*2*N, subRect;

            for(int i = 0; i < N; i++) for (int j = 0; j< N; j++){
                colPrefixSum[i][j] = input.nextInt();
                if(i > 0) colPrefixSum[i][j] += colPrefixSum[i-1][j];
                if (j > 0) colPrefixSum[i][j] += colPrefixSum[i][j-1];
                if (i > 0 && j > 0) colPrefixSum[i][j] -= colPrefixSum[i-1][j-1];
            }

            for(int i = 0; i < N; i++) for(int j = N; j < N*2; j++){
                colPrefixSum[i][j] = colPrefixSum[i][j-N];
            }
            for(int[] row : colPrefixSum){
                System.out.println(Arrays.toString(row));
            }
            for(int i = 0; i < N; i++) for (int j = 0; j < N*2; j++)
                for (int k = i; k < N; k++) for (int L = j; L < N*2; L++){
                    subRect = colPrefixSum[k][L];
                    if (i > 0) subRect -= colPrefixSum[i-1][L];
                    if (j > 0) subRect -= colPrefixSum[k][j-1];
                    if (i > 0 && j > 0) subRect += colPrefixSum[i-1][j-1];
                    best = Math.max(subRect, best);
                }

            printer.println(best);
        }
        printer.close();
    }
}

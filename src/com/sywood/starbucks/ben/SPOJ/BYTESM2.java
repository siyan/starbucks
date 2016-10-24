package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BYTESM2 {
    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream i){
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
        int T = input.nextInt();
        int[][] memo = new int[100][100];
        int[][] stones = new int[100][100];
        int rows;
        int col;
        for(int t = 1; t <= T; t++) {
            rows = input.nextInt();
            col = input.nextInt();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < col; j++) {
                    stones[i][j] = input.nextInt();
                }
            }
            int best = 0;
            for (int i = 0; i < col; i++) {
                memo[0][i] = stones[0][i];
            }

            for(int i = 1; i < rows; i++){
                for (int j = 0; j < col; j++) {
                    memo[i][j] = memo[i-1][j];
                    if(j > 0)
                        memo[i][j] = memo[i][j] > memo[i-1][j-1] ? memo[i][j] : memo[i-1][j-1];
                    if(j < col-1)
                        memo[i][j] = memo[i][j] > memo[i-1][j+1] ? memo[i][j] : memo[i-1][j+1];
                    memo[i][j] += stones[i][j];
                }
            }

            for(int i = 0; i < col; i++){
                best = best > memo[rows-1][i] ? best : memo[rows-1][i];
            }

            System.out.println(best);
        }
    }
}

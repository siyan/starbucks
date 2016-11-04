package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DIEHARD {
    private static int max(int a, int b){
        return a > b ? a : b;
    }
    private static int[][] memo = new int[4000][4000];
    private static int calc(int H, int A){
        if(H <= 0 || A <= 0) return -1;

        else if(memo[H][A] != -1) return memo[H][A];

        return memo[H][A] = max(calc(H-17, A+7), calc(H-2, A-8))+2;
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner((System.in));
        int T = input.nextInt();
        for(int t = 1; t <= T; t++){
            int H = input.nextInt();
            int A = input.nextInt();
            for(int[] row : memo)
                Arrays.fill(row, -1);

            System.out.println(calc(H, A));
        }
    }
    private static class FastScanner {
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
}

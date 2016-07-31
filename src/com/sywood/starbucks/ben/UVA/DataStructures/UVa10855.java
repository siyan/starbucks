package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2D array problem
 */
public class UVa10855 {
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
        PrintWriter printer = new PrintWriter(System.out);
        int N = input.nextInt();
        int n = input.nextInt();

        while(N != 0 && n != 0){
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                arr[N] = input.readLine().toCharArray();
            }
            char[][] find = new char[n][n];
            for (int i = 0; i < n; i++) {
                find[n] = input.readLine().toCharArray();
            }

        }
    }
}

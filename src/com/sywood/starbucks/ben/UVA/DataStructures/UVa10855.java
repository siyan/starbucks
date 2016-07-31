package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.*;
import java.util.Arrays;
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
    private static char[][] rotate(char[][] process){
        char[][] copy = new char[process.length][process.length];
        for(int col = process.length-1; col >= 0; col--){
            for(int row = 0; row < process.length; row++){
                copy[row][col] = process[process.length-col-1][row];
            }
        }
        return copy;
    }


    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        PrintWriter printer = new PrintWriter(System.out);
        int N = input.nextInt();
        int n = input.nextInt();
        int count;
        boolean found;
        char[][] arr, find;
        int[] cnt;

        while(N != 0 && n != 0){
            cnt = new int[4];
            arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = input.readLine().toCharArray();
            }
            find = new char[n][n];
            for (int i = 0; i < n; i++) {
                find[i] = input.readLine().toCharArray();
            }
            found = true;
            for (int i = 0; i < 4; i++) { // goes through all 4 rotations
                count = 0;
                for(int row = 0; row <= N-n; row++){
                    for(int col = 0; col <= N-n; col++){

                        for(int r = 0; r < n && found; r++){
                            for(int c = 0; c < n && found; c++){
                                found = (arr[row+r][col+c] == find[r][c]);
                            }
                        }
                        if (found) cnt[i]++;
                        found = true;

                    }
                }
                find = rotate(find);
            }
            printer.printf("%d %d %d %d\n", cnt[0], cnt[1], cnt[2], cnt[3]);
            N = input.nextInt();
            n = input.nextInt();
        }
        printer.close();
    }
}

package com.sywood.starbucks.ben.HackerRank.WalmarCodesprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FibSum {
    private static int[] memo = new int[100000];
    private static int[] num = new int[100002];
    private static int mod = 1000000007;
    private static int fib(int i){
        if(i == 1 || i == 2)
            return 1;
        else{
            if(memo[i] != -1)
                return memo[i];

            memo[i] = (fib(i-1) + fib(i-2));
            memo[i] %= mod;
            return memo[i];
        }
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        int q = input.nextInt();
        Arrays.fill(memo, -1);
        fib(99999);
        for (int i = 0; i < q; i++) {
            int n = input.nextInt();
            for (int j = 1; j <= n; j++) {
                num[j] = input.nextInt() + num[j-1];
            }

            long total = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    total += fib(num[k]-num[j-1]);
                }
            }
            System.out.println(total%mod);

        }
    }

    public static  class FastScanner {
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

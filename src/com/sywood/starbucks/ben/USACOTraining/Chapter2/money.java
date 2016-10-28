package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: money
 */
public class money {
    private static int N, target;
    private static int[] coins;

    private static long coinChange(){
        long[][] memo = new long[target+1][N+1];

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < coins.length; j++){
                if (i == 0)
                    memo[i][j] = 1;
                else if (j == 0)
                    if (i % coins[j] == 0)
                        memo[i][j] = 1;
                    else
                        memo[i][j] = 0;
                else if( coins[j] > i)
                    memo[i][j] = memo[i][j-1];
                else
                    memo[i][j] = memo[i - coins[j]][j] + memo[i][j-1];
            }
        }
        return memo[target][coins.length-1];
    }

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
        FastScanner input = new FastScanner(new FileInputStream("money.in"));//new FileInputStream("money.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));

        N = input.nextInt();
        target = input.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println(i);
            coins[i] = input.nextInt();
        }
        printer.println(coinChange());
        printer.close();
    }
}

package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * second underlined dp
 */
public class UVa10684 {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i){
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException{
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
        public String nextLine() throws IOException{
            return br.readLine();
        }
    }

    public static void main(String[] args)throws IOException{
        FastScanner input = new FastScanner(System.in);
        int n = input.nextInt();
        while (n != 0){
            int[] money = new int[n];
            for (int i = 0; i < n; i++) {
                money[i] = input.nextInt();
            }
            long sum = 0;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                sum += money[i];
                ans = Math.max(sum, ans);
                if (sum < 0){
                    sum = 0;
                }
            }
            if (ans == 0){
                System.out.println("Losing streak.");
            }else{
                System.out.println("The maximum winning streak is " + ans +".");
            }
            n = input.nextInt();
        }
    }
}

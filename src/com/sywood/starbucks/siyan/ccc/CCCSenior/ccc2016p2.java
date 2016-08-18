package com.sywood.starbucks.siyan.ccc.CCCSenior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-17.
 */
public class ccc2016p2 {
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
        int type = input.nextInt();
        int N = input.nextInt();

        int[] first = new int[N];
        Integer[] second = new Integer[N];

        for (int i = 0; i < N; i++) {
            first[i] = input.nextInt();
        }
        for(int i = 0; i < N; i++){
            second[i] = input.nextInt();
        }

        Arrays.sort(first);

        if (type == 1){
            Arrays.sort(second);
            int min = 0;
            for (int i = 0; i < N; i++) {
                min += Math.max(first[i], second[i]);
            }
            System.out.println(min);
        }else{
            int max = 0;
            Arrays.sort(second, Collections.<Integer>reverseOrder());
            for (int i = 0; i < N; i++) {
                max += Math.max(first[i], second[i]);
            }
            System.out.println(max);
        }

    }
}

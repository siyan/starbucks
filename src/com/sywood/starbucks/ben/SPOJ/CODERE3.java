package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CODERE3 {
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

    private static int LDS(int[] A) {
        int[] m = new int[A.length];
        int[] mH = new int[A.length];
        //Arrays.fill(m, 1);//not important here
        for (int x = A.length - 2; x >= 0; x--) {
            for (int y = A.length - 1; y > x; y--) {
                if (m[x] <= m[y] && A[x] > A[y]) {
                    m[x]=m[y]+1;//or use m[x]++
                }
                if (mH[x] <= mH[y] && A[x] < A[y]) {
                    mH[x]=mH[y]+1;//or use m[x]++
                }
            }
        }
        int max = m[0] + mH[0];
        for (int i = 0; i < m.length; i++) {
            max = max > m[i]+mH[i] ? max : m[i] + mH[i];
        }

        return max;
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);

        int T = input.nextInt();
        int N;
        int[] array;
        for(int t = 1; t <= T; t++){
            N = input.nextInt();
            array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = input.nextInt();
            }
            System.out.println(LDS(array));
        }
    }
}

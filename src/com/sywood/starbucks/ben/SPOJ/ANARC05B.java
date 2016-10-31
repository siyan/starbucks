package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ANARC05B {
    private static int firstLen, secLen;
    private static int[] first = new int[10001], sec = new int[10001];

    private static int max(int a, int b){
        return a > b ? a : b;
    }

    private static int solve(){
        int best = 0;
        int tSum = 0, bSum = 0;

        for(int tI = 0, bI = 0; tI < firstLen || bI < secLen;){
            if(tI < firstLen && bI < secLen) {

                if (sec[bI] < first[tI]) {
                    bSum += sec[bI];
                    bI++;
                } else if (first[tI] < sec[bI]){
                    tSum += first[tI];
                    tI++;
                }else {
                    best += first[tI];
                    best += max(tSum, bSum);
                    tI++;
                    tSum = 0;
                    bI++;
                    bSum = 0;
                }
            }else if (tI < firstLen){
                tSum += first[tI++];
            }else{
                bSum += sec[bI++];
            }
        }
        return best + max(tSum, bSum);
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        firstLen = input.nextInt();
        while(firstLen != 0){
            for (int i = 0; i < firstLen; i++) {
                first[i] = input.nextInt();
            }
            secLen = input.nextInt();
            for (int i = 0; i < secLen; i++) {
                sec[i] = input.nextInt();
            }

            System.out.println(solve());
            firstLen = input.nextInt();
        }
    }

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
}

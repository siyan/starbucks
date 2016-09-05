package com.sywood.starbucks.siyan.algo.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by siyan on 2016-09-04.
 */
public class UVa11655 {

    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        StringTokenizer st;
        while (!line.equals("0 0 0 0")) {
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) * (N + 1);
            int T = Integer.parseInt(st.nextToken()) * (N + 1);
            double X = (int)((double) x / 1.1 - T);
            int K = Integer.parseInt(st.nextToken());
            int[] v = new int[2*K];
            int[] w = new int[2*K];
            for (int i = 0; i < K; i++) {
                line = input.readLine();
                st = new StringTokenizer(line);
                v[i] = Integer.parseInt(st.nextToken());
                v[K+i] = v[i];
                for (int j = 0; j <= N; j++) {
                    w[i] += Integer.parseInt(st.nextToken());
                }
                w[K+i] = w[i];
            }


            int[][] memo = new int[K+K+1][(int)X+1];
            for( int j = 0; j <= X; j++ ){
                memo[0][j] = 0;
            }

            for(int i = 1; i <= K + K; i++ ) {
                for( int j = 0; j <= X; j++ ){
                    if( v[i-1] > j)
                        memo[i][j] = memo[i-1][j];
                    else {
                        int d1 = memo[i - 1][j];
                        int d2 = memo[i - 1][j-v[i-1]] + w[i-1];
                        memo[i][j] = Math.max(d1, d2);
                    }

                    //System.out.println( i + ":" + j + " = " + (memo[i][j] ));
                }
            }
            System.out.printf("%.02f\n",  memo[K + K][ (int)X] / (float)( N + 1 ) );
            line = input.readLine();
        }

    }
}

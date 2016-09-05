package com.sywood.starbucks.siyan.algo.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
9 100 20 20
9 2 4 10 1 9 1 5 9 6 4
1 3 5 5 5 5 6 3 10 4 9
4 2 2 1 0 8 3 3 4 8 1
4 7 10 3 1 1 7 6 8 8 1
4 6 3 2 2 9 2 6 7 1 8
10 8 9 7 1 3 7 4 9 9 7
7 3 5 1 2 1 8 2 4 4 4
6 6 2 7 2 3 5 0 5 4 7
7 10 5 3 6 2 7 4 4 7 7
7 5 2 5 8 4 8 1 4 8 8
6 7 0 9 4 9 8 9 5 4 9
7 1 7 1 6 2 8 9 2 8 8
8 1 7 7 7 1 5 5 8 1 2
5 4 10 1 8 6 10 2 9 0 8
3 5 0 10 4 3 6 5 8 2 6
1 7 7 7 2 0 1 1 5 0 5
2 0 7 6 2 6 3 8 7 9 2
5 6 4 7 9 0 5 2 1 6 3
2 7 7 5 9 6 4 8 4 3 0
3 2 3 7 10 3 4 9 3 7 9
0 0 0 0

 112.60
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

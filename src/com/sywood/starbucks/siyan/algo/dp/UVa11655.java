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
            double W = (int)((double) x / 1.1 - T);
            int K = Integer.parseInt(st.nextToken());
            int[] w = new int[2*K];
            int[] v = new int[2*K];
            int dishesOrdered = 0;
            for (int i = 0; i < K; i++) {
                line = input.readLine();
                st = new StringTokenizer(line);
                w[i] = Integer.parseInt(st.nextToken());
                w[K+i] = w[i];
                for (int j = 0; j <= N; j++) {
                    v[i] += Integer.parseInt(st.nextToken());
                }
                v[K+i] = v[i];
            }


            int[][] vals = new int[K+K+1][(int)W+1];
            int[][] weits = new int[K+K+1][(int)W+1];
            for( int j = 0; j <= W; j++ ){
                vals[0][j] = 0;
            }

            int ordered = 0;
            for(int i = 1; i <= K + K; i++ ) {
                for( int j = 0; j <= W; j++ ){
                    if( w[i-1] > j || dishesOrdered >= 2 * ( N + 1 )) {
                        vals[i][j] = vals[i - 1][j];
                        ordered = 0;
                    }
                    else {
                        int d1 = vals[i - 1][j];
                        int d2 = vals[i - 1][j-w[i-1]] + v[i-1];
                        vals[i][j] = d1 > d2 ? d1 : d2;
                        if( d1 > d2 ) {
                            vals[i][j] = d1;
                            ordered = -1;
                        }
                        else {
                            weits[i][j] = d2;
                            ordered = 1;
                        }
                    }
                    //System.out.println( i + ":" + " = " + weits[i][j]  + " -- " + (vals[i][j] / (N +1)));
                }
                dishesOrdered += ordered;
                System.out.println( i + ":" + dishesOrdered + " = " + vals[i][(int)W]  + " -- " + (vals[i][(int)W] / (N +1)));
            }
            System.out.printf("%.02f\n",  vals[K + K][ (int)W] / (float)( N + 1 ) );
            line = input.readLine();
        }

    }
}

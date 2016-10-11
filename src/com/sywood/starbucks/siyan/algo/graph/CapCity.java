package com.sywood.starbucks.siyan.algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by siyan on 2016-10-10.
 */
public class CapCity {

    static List<Integer>[] G;
    static boolean[] marked;
    static int count;
    static boolean[] CAP;
    static int N;

    static int min( int a, int b ) {
        return a > b ? a : b;
    }

    static void dfs( int n ) {
        marked[n] = true;
        count++;
        for( int v : G[n] ) {
            if( CAP[v]) {
                CAP[n] = true;
                return;
            }
            if( !marked[v] ) dfs( v );
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());


        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        G = new ArrayList[N];
        CAP = new boolean[N];

        for( int i = 0; i < G.length; i++ ) {
            G[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            // reverse graph
            G[b].add(a);
        }

        for( int i = 0; i < N; i++ ) {
            marked = new boolean[G.length];
            dfs( i );
            if( count == N ) CAP[i] = true;
            count = 0;
        }

        System.out.println(Arrays.toString( CAP ));

    }
}



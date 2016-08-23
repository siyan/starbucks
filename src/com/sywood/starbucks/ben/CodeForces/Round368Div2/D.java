package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.BitSet;

/**
 * http://codeforces.com/contest/707/problem/D
 */

public class D {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int i, j;

        int[] state = new int[q+1];
        BitSet[][] previous = new BitSet[q+1][];
        previous[0] = new BitSet[n];
        for(i = 0; i < n; i++){
            previous[0][i] = new BitSet(m);
        }
        state[0] = 0;

        for (int t = 1; t <= q; t++) {
            state[t] += state[t-1];
            st = new StringTokenizer(input.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 4){
                i = Integer.parseInt(st.nextToken());
                printer.println(state[i]);
                previous[t] = new BitSet[n];
                for (int k = 0; k < n; k++) { //sets current to previous
                    previous[t][k] = (BitSet) previous[i][k].clone();
                }
                state[t] = state[i];
            } else {
                previous[t] = new BitSet[n];
                for (int k = 0; k < n; k++) {
                    previous[t][k] = (BitSet) previous[t-1][k].clone();
                }
                if (type == 1) {
                    i = Integer.parseInt(st.nextToken())-1;
                    j = Integer.parseInt(st.nextToken())-1;
                    state[t] += previous[t][i].get(j) ? 0 : 1;
                    previous[t][i].set(j, true);
                } else if (type == 2) {
                    i = Integer.parseInt(st.nextToken())-1;
                    j = Integer.parseInt(st.nextToken())-1;
                    state[t] -= previous[t][i].get(j) ? 1 : 0;
                    previous[t][i].set(j, false);
                } else if (type == 3) {
                    i = Integer.parseInt(st.nextToken())-1;
                    state[t] += (m - previous[t][i].cardinality()) - previous[t][i].cardinality();
                    for (int k = 0; k < m; k++) {
                        previous[t][i].flip(k);
                    }
                }
                printer.println(state[t]);
            }
        }
        printer.close();
    }
}
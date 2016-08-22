package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
        BitSet[] current = new BitSet[n];
        for (int k = 0; k < n; k++) {
            current[k] = new BitSet(m);
        }
        BitSet[][] previous = new BitSet[q+1][];
        previous[0] = Arrays.copyOf(current, n);
        state[0] = 0;

        for (int t = 1; t <= q; t++) {
            state[t] += state[t-1];
            st = new StringTokenizer(input.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 4){
                i = Integer.parseInt(st.nextToken());
                printer.println(state[i]);
                current = Arrays.copyOf(previous[i], n);
                previous[t] = Arrays.copyOf(current, n);
                state[t] = state[i];
            }else {
                if (type == 1) {
                    i = Integer.parseInt(st.nextToken())-1;
                    j = Integer.parseInt(st.nextToken())-1;
                    state[t] += current[i].get(j) ? 0 : 1;
                    current[i].set(j, true);
                } else if (type == 2) {
                    i = Integer.parseInt(st.nextToken())-1;
                    j = Integer.parseInt(st.nextToken())-1;
                    state[t] -= current[i].get(j) ? 1 : 0;
                    current[i].set(j, false);
                } else if (type == 3) {
                    i = Integer.parseInt(st.nextToken())-1;
                    state[t] += (m - current[i].cardinality()) - current[i].cardinality();
                    for (int k = 0; k < m; k++) {
                        current[i].flip(k);
                    }
                }
                printer.println(state[t]);
                previous[t] = Arrays.copyOf(current, n);
            }
        }
        printer.close();
    }
}

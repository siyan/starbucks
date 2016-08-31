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

        int type, i, j;

        int[] state = new int[q+1];
        state[0] = 0;
        BitSet[] previous = new BitSet[q+1]; //stores the shelf modified
        for (int k = 0; k <= q; k++) {
            previous[0] = new BitSet(m);
        }
        int[][] shelves = new int[q+1][n]; //stores indices of the shelves

        BitSet allOnes = new BitSet(m);
        for (int k = 0; k < m; k++) {
            allOnes.set(k);
        }

        for (int k = 1; k <= q; k++) {
            st = new StringTokenizer(input.readLine());
            type = Integer.parseInt(st.nextToken());

            if (type == 4){
                i = Integer.parseInt(st.nextToken());
                shelves[k] = Arrays.copyOf(shelves[i], n);
                state[k] = state[i];
            }else{
                state[k] = state[k-1];
                shelves[k] = Arrays.copyOf(shelves[k-1], n);
                i = Integer.parseInt(st.nextToken())-1;
                previous[k] = (BitSet) previous[shelves[k][i]].clone();
                shelves[k][i] = k;
                if (type == 1){
                    j = Integer.parseInt(st.nextToken())-1;

                    state[k] += previous[k].get(j) ? 0 : 1;
                    previous[k].set(j);

                }else if (type == 2) {
                    j = Integer.parseInt(st.nextToken())-1;

                    state[k] -= previous[k].get(j) ? 1 : 0;

                    previous[k].set(j, false);
                }else if (type == 3) {
                    state[k] += (m - previous[k].cardinality()) - previous[k].cardinality();

                    previous[k].xor(allOnes);
                }
            }
            printer.println(state[k]);
        }

        printer.close();
    }
}
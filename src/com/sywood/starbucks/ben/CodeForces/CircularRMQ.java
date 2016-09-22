package com.sywood.starbucks.ben.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * need to actually create a new segement tree class to solve this problem.
 * http://codeforces.com/blog/entry/18051
 */
public class CircularRMQ {
    class SegmentTree {
        int N = (int) 1e5;
        int n;
        int t[] = new int[2 * N];
        int h = Integer.highestOneBit(n);
        int delta[] = new int[N];


        void build() {
            for (int i = n - 1; i > 0; i--)
                t[i] = t[i << 1] + t[i << 1 | 1];
        }

        void modify(int p, int value) { // single point
            for (t[p += n] = value; p > 1; p >>= 1)
                t[p >> 1] = t[p] + t[p ^ 1];
        }

        void modify(int l, int r, int value){ //inclusive, exclusive
            for(l += n, r += n; l < r; l >>=1, r>>=1){
                if ((l&1) > 0) t[l++] += value;
                if ((r&1) > 0) t[r--] += value;
            }
        }

        int query(int p) {
            int res = 0;
            for (p += n; p > 0; p >>= 1) res += t[p];
            return res;
        }

        void push() {
            for (int i = 1; i < n; i++) {
                t[i << 1] += t[i];
                t[i << 1 | 1] += t[i];
                t[i] = 0;
            }
        }

        void apply(int p, int value){

        }

    }
}

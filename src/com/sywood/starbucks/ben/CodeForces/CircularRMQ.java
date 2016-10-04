package com.sywood.starbucks.ben.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * need to actually create a new segement tree class to solve this problem.
 * http://codeforces.com/blog/entry/18051
 */
public class CircularRMQ {
    private static class SegmentTree {
        int N = (int) 1e5;
        int n;
        int[] t;
        int[] d;
        int h = Integer.highestOneBit(n);

        public SegmentTree(int n){
            this.n = n;
            h = Integer.highestOneBit(n);
            t = new int[2*n];
            d = new int[n];
        }

        void push(int p) {
            for(int s = h; s > 0; --s){
                int i = p >> s;
                if (d[i] != 0){
                    apply(i<<1, d[i]);
                    apply((i<<1)|1, d[i]);
                    d[i] = 0;
                }
            }
        }

        void apply(int p, int value){
            t[p] += value;
            if (p < n) d[p] += value;
        }

        void build(int p){ //for max value
            while(p > 1) {
                p >>= 1;
                t[p] = Math.max(t[p<<1], t[p<<1|1]) + d[p];
            }
        }

        void inc(int l, int r, int value){ //[l, r)
            l += n; r += n;
            int l0 = l; int r0 = r;
            for(; l < r; l >>= 1, r >>= 1){
                if ((l&1) > 0) apply(l++, value);
                if ((r&1) > 0) apply(--r, value);
            }
            build(l0);
            build(r0-1);
        }

        //max query, change to Math.min for minimum, and gcd for gcd
        int minQuery(int l, int r){
            l += n; r += n;
            push(l);
            push(r-1);
            int res = Integer.MAX_VALUE;

            for(; l < r; l>>=1, r>>=1){
                if((l&1) >= 0) res = Math.min(res, t[l++]);
                if((r&1) >= 0) res = Math.min(t[--r], res);
            }
            return res;
        }

    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        SegmentTree t = new SegmentTree(n);
        String[] data = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            t.inc(i, i+1, Integer.parseInt(data[i]));
        }
        n = Integer.parseInt(input.readLine());
        int l, r;
        for(int tt = 1; tt <= n; tt++){
            data = input.readLine().split(" ");
            l = Integer.parseInt(data[0]);
            r = Integer.parseInt(data[1]);
            if (data.length == 3){
                if (l <= r){
                    t.inc(l, r+1, Integer.parseInt(data[2]));
                }else{
                    t.inc(l, t.n, Integer.parseInt(data[2]));
                    t.inc(0, r+1, Integer.parseInt(data[2]));
                }
            }else{
                if (l <= r){
                    System.out.println(t.minQuery(l, r+1));
                }else{
                    System.out.println(Math.min(t.minQuery(l, t.n), t.minQuery(0, r+1)));
                }
            }
        }
    }
}

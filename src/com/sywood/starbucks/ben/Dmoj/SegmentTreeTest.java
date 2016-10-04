package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-05.
 */
public class SegmentTreeTest {
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
                if((l&1) > 0) res = Math.min(res, t[l++]);
                if((r&1) > 0) res = Math.min(t[--r], res);
            }
            return res;
        }
        int gcd(int a, int b){
            if (b == 0){
                return a;
            }
            return gcd(b, a%b);
        }

        int gcdQ(int l, int r){
            l += n; r += n;
            push(l);
            push(r-1);
            int res = t[l];
            for(; l < r; l >>=1, r>>=1){
                if((l&1) > 0) res = gcd(res, t[l++]);
                if((r&1) > 0) res = gcd(t[--r], res);
            }
            return res;
        }

        //below is range sum calculations
        //k is the length of the interval.
        //p is parent
        void calc(int p, int k){ //range sum
            if(d[p] == 0) t[p] = t[p<<1] + t[(p<<1)|1];
            else t[p] = d[p]*k;
        }
        void apply(int p, int value, int k){
            t[p] = value*k;
            if (p < n) d[p] = value;
        }

        void build(int l, int r){
            int k = 2;
            for(l += n, r += n-1; l > 1; k <<=1){
                l >>= 1; r >>= 1;
                for(int i = r; i >= l; i--)calc(i, k);
            }
        }

        void push(int l, int r){
            int s = h, k = 1 << (h-1);
            for(l += n, r += n-1; s > 0; --s, k >>= 1)
                for(int i = 1 >>s; i <= r>>s; ++i) if (d[i] != 0){
                    apply(i<<1, d[i], k);
                    apply((i<<1)|1, d[i], k);
                    d[i] = 0;
                }
        }

        void modify(int l, int r, int value){
            if (value == 0) return;
            push(l, l+1);
            push(r-1, r);
            int l0 = l, r0 = r, k = 1;

            for(l += n, r += n; l < r; l >>= 1, r>>= 1, k <<= 1){
                if((l&1) > 0) apply(l++, value, k);
                if((r&1) > 0) apply(--r, value, k);
            }
            build(l0, l0+1);
            build(r0-1, r0);
        }

        int sumQuery(int l, int r){
            push(l, l+1);
            push(r-1, r);
            int res = 0;
            for(l += n, r += n; l < r; l >>= 1, r>>= 1){
                if ((l&1) > 0) res += t[l++];
                if ((r&1) > 0) res += t[--r];
            }
            return res;
        }

        public String toString(){
            String ret = "";
            for (int i = 0; i < n; i++) {
                ret += sumQuery(i, i+1) + ", ";
            }
            return ret;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        SegmentTree t = new SegmentTree(n);
        int l, r;
        String[] data = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            t.inc(i, i+1, Integer.parseInt(data[i]));
        }
        for (int i = 0; i < m; i++) {
            data = input.readLine().split(" ");
            l = Integer.parseInt(data[1]);
            r = Integer.parseInt(data[2]);
            //System.out.println(l + ", " + r);
            switch(data[0]){
                case "C":
                    t.modify(l-1, l, r);
                    break;
                case "M":
                    System.out.println(t.minQuery(l-1, r));
                    break;
                case "G":
                    System.out.println(t.gcdQ(l-1, r));
                    break;

            }
        }
    }
}

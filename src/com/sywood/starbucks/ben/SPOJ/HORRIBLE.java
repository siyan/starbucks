package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
1
8 9
0 2 4 26
0 4 8 80
0 4 5 20
1 8 8
0 5 7 14
1 4 8
1 3 8
1 2 3
1 2 5

 OUTPUT:
 80
 508
 534
 */
public class HORRIBLE {
    private static class SegmentTree {
        int n;
        long[] t;
        long[] d;
        int h;

        public SegmentTree(int n){
            this.n = n;
            h = Integer.highestOneBit(n);
            t = new long[2*n];
            d = new long[n];
        }

        //below is range sum calculations
        //k is the length of the interval.
        //p is parent
        void calc(int p, int k){ //range sum
            if(d[p] == 0) t[p] = t[p<<1] + t[(p<<1)|1];
            else t[p] += d[p]*k;
        }

        void apply(int p, long value, int k){
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
                for(int i = l >> s; i <= r>>s; ++i) if (d[i] != 0){
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
        int T = Integer.parseInt(input.readLine());
        int N, C, c, p, q;
        StringTokenizer st;
        for(int t = 1; t++ <= T; ){
            st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            SegmentTree tree = new SegmentTree(N);
            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(input.readLine());
                c = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken())-1;
                q = Integer.parseInt(st.nextToken());
                switch(c){
                    case 0:
                        tree.modify(p, q, Integer.parseInt(st.nextToken()));
                        System.out.println(tree.toString());
                        break;
                    default:
                        System.out.println(tree.sumQuery(p, q));
                        break;
                }
            }
        }
    }
}

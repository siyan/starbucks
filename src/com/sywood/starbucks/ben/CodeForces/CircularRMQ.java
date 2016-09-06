package com.sywood.starbucks.ben.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-05.
 */
public class CircularRMQ {
    static class SegmentTree {
        static int[] delta;
        static int[] gcd;
        static int[] minVal; // this can also be maxValue, etc.
        static int[] lo;
        static int[] hi;
        public SegmentTree(int size){
            if(size == 1)size++;
            delta = new int[4*(size-1)+1];
            minVal = new int[4*(size-1)+1];
            lo = new int[4*(size-1)+1];
            hi = new int[4*(size-1)+1];
            init(1, 0, size-1);
        }
        void prop(int i) {
            delta[2*i] += delta[i];
            delta[2*i+1] += delta[i];
            delta[i] = 0;
        }
        int gcd(int a, int b){
            if (b == 0) return a;

            return gcd(b, a%b);
        }

        void updateMin(int i)
        { //finds new min at point i by looking at all the intervals between
            minVal[i] = Math.min(minVal[2*i] + delta[2*i], minVal[2*i+1] + delta[2*i+1]);
        }

        void init(int i, int left, int right){
            lo[i] = left;
            hi[i] = right;
            if (left==right)return;
            int m = (left+right)/2;
            init(2*i, left, m);
            init(2*i+1, m+1, right);
        }

        void add(int i, int left, int right, int x){
            if(hi[i] < left || right < lo[i])return;
            if(left <= lo[i] && hi[i] <= right){
                delta[i] += x;
                return;
            }
            prop(i);
            add(2*i, left, right, x);
            add(2*i+1, left, right, x);
            updateMin(i);
        }

        int minQuery (int i, int left, int right){
            if(hi[i] < left || right < lo[i]) return Integer.MAX_VALUE;
            if(left <= lo[i] && hi[i] <= right){
                return delta[i] + minVal[i];
            }
            prop(i);
            int minLeft = minQuery(2*i, left, right);
            int minRight = minQuery(2*i+1, left, right);
            updateMin(i);
            return Math.min(minLeft, minRight);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        SegmentTree segTree = new SegmentTree(n);

        StringTokenizer st = new StringTokenizer(input.readLine());

        for (int i = 0; i < n; i++) {
            segTree.add(0, i, i, Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(input.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int lf = Integer.parseInt(st.nextToken());
            int rg = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()){
                int value = Integer.parseInt(st.nextToken());
                if (lf > rg) {
                    segTree.add(0, lf, n - 1, value);
                    segTree.add(0, 0, rg, value);
                }else
                    segTree.add(0, lf, rg, value);
            }else{
                if (lf > rg){
                    printer.println(Math.min(segTree.minQuery(0, lf, n-1), segTree.minQuery(0, 0, rg)));
                }else{
                    printer.println(segTree.minQuery(0, lf, rg));
                }
            }
        }
        printer.close();
    }
}

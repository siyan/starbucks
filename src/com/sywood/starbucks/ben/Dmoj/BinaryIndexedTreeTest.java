package com.sywood.starbucks.ben.Dmoj;

/**
 * Created by Ben on 2016-10-31.
 */
public class BinaryIndexedTreeTest {
    private static class FenwickTree {
        long[] tree;

        public FenwickTree(long[] init, int size){
            tree = new long[size+1];
            for (int i = 0; i < size; i++) {
                long add = init[i];
                int k = i;
                for(; k <= size; k &= -k){
                    tree[k] += add;
                }
            }
        }

        long rsq(int b ){
            long sum = 0;
            for(; b > 0; b -= (b&(-b))){
                sum += tree[b];
            }
            return sum;
        }
        long rsq(int a, int b){
            return rsq(b) - (a == 1 ? 0: rsq(a-1));
        }
        void update(int k, int v){
            for(; k < tree.length; k+= (k&(-k))){
                tree[k] += v;
            }
        }

        public static void main(String[] args){
            FenwickTree tree = new FenwickTree(new long[9], 9);

        }
    }
}

package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinaryIndexedTreeTest {
    private static class FenwickTree {
        long[] tree;
        int size;
        FenwickTree(long[] init, int size){
            tree = new long[size+1];
            this.size = size;
            for (int i = 0; i < size; i++) {
                update(i+1, init[i]);
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
            return rsq(b) - rsq(a-1);
        }

        void update(int k, long v){
            long orig = rsq(k, k);
            for(; k <= size; k += (k&(-k))){
                tree[k] += v-orig;
            }
        }

        int allLessThan(int v){
            int count = 0;
            for(int i = 1; i <= size; i++){
                if(rsq(i, i) <= v) count++;
            }
            return count;
        }

        public String toString(){
            String ret = "";
            for (int i = 1; i < size; i++) {
                ret += rsq(i, i) + ", ";
            }
            return ret;
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] init = new long[N];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            init[i] = Long.parseLong(st.nextToken());
        }
        FenwickTree tree = new FenwickTree(init, N);
        String command;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            command = st.nextToken();
            switch (command){
                case "C":
                    tree.update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case "S":
                    printer.println(tree.rsq(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                    break;
                case "Q":
                    printer.println(tree.allLessThan(Integer.parseInt(st.nextToken())));
            }
        }
        printer.close();
    }
}

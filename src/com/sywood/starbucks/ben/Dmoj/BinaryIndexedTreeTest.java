package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinaryIndexedTreeTest {
    private static class FenwickTree {
        long[] tree;
        long[] freq;
        int size;
        FenwickTree(int[] init, int size){
            tree = new long[size+1];
            freq = new long[100001];
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

        void update(int k, int v){
            int orig = (int) rsq(k, k);
            int k1 = k;
            for(; k1 <= size; k1 += (k1&(-k1))){
                tree[k1] += v-orig;
            }
            k1 = orig;
            if(k1 > 0) {
                for (; k1 <= 100000; k1 += (k1 & (-k1)))
                    freq[k1]--;
            }
            k1 = v;
            if(k1 > 0) {
                for (; k1 <= 100000; k1 += (k1 & (-k1))) {
                    freq[k1]++;
                }
            }
        }

        long allLessThan(int v){
            long count = 0;
            for(; v > 0; v -= v&-v) {
                //System.out.println(v + ", " + freq[v]);
                count += freq[v];
            }
            return count;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] init = new int[N];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }
        FenwickTree tree = new FenwickTree(init, N);
        String command;
        //System.out.println(Arrays.toString(tree.freq));
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

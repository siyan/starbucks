package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Striker on 2016-09-26.
 */
public class GridlandMetro2 {
    private static class t implements Comparable<t>{
        int r, start, end;
        public t(int r, int start, int end){
            this.r = r;
            this.start = start;
            this.end = end;
        }
        public int compareTo(t other){
            if (r == other.r){
                if(start == other.start)
                    return Integer.compare(end, other.end);
                return Integer.compare(start, other.start);
            }
            return Integer.compare(r, other.start);
        }
        public String toString(){
            return (r + ", " + start + ", " + end);
        }
    }
    public static void main(String[] args)throws Exception{
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long m = in.nextInt();
        int k = in.nextInt();
        t[] lst = new t[k];
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                lst[i] = new t(in.nextInt(), in.nextInt(), in.nextInt());
            }
            Arrays.sort(lst);

            int curr = lst[0].r;
            long total = n * m;
            int start = lst[0].start;
            int end = lst[0].end;
            for (int i = 0; i < k; i++) {
                if (curr == lst[i].r) {
                    if (lst[i].start >= start && lst[i].start <= end) {
                        end = Math.max(end, lst[i].end);
                    } else if (lst[i].end <= end && lst[i].end >= start) {
                        start = Math.min(lst[i].start, start);
                    } else {
                        total -= (end - start + 1);
                        start = lst[i].start;
                        end = lst[i].start;
                    }

                } else {
                    total -= (end - start + 1);
                    curr = lst[i].r;
                    start = lst[i].start;
                    end = lst[i].end;
                }
                if (i == k - 1) {
                    total -= (end - start + 1);
                }
            }
            System.out.println(total);
        }else{
            System.out.println(n*m);
        }
    }
}

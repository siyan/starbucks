package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Ben on 2016-09-24.
 */
public class GridlandMetro{
    private static class interval implements Comparable<interval>{
        int r, start, end;

        public interval(int r, int start, int end){
            this.r = r;
            this.start = start;
            this.end = end;
        }

        public int compareTo(interval other){
            if(r == other.r){
                if (start == other.start){
                    return Integer.compare(end, other.end);
                }
                return Integer.compare(start, other.start);
            }
            return Integer.compare(r, other.r);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<interval> ranges = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(input.readLine());
            ranges.add(new interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
        }

        long total = n*m;
        int currRow = 1;
        boolean[] curr = new boolean[m];
        while(!ranges.isEmpty()){
            interval current = ranges.poll();
            if (current.r != currRow){
                currRow = current.r;
                curr = new boolean[m];
            }
            for(int start = current.start; start <= current.end; start++){
                if(!curr[start]){
                    curr[start] = true;
                    total--;
                }
            }
        }
        System.out.println(total);
    }
}

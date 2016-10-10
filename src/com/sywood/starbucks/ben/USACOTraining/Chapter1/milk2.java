package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: milk2
 */
public class milk2 {
    private static class interval implements Comparable<interval>{
        int start;
        int end;
        public interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(interval other){
            if(start == other.start){
                return end < other.end ? -1 : 1;
            }
            return start < other.start ? -1 : 1;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("milk2.in")));//System.in));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));//System.out);
        int N = Integer.parseInt(input.readLine());
        PriorityQueue<interval> set = new PriorityQueue<interval>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            set.add(new interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        interval curr = set.poll();
        int currStart = curr.start;
        int currEnd = curr.end;
        int bestMilk = curr.end-curr.start;
        int bestNo = 0;
        while(!set.isEmpty()){
            curr = set.poll();
            if(curr.start > currStart && curr.start <= currEnd){
                currEnd = Math.max(currEnd, curr.end);
                bestMilk = Math.max(bestMilk, currEnd-currStart);
            }else{
                bestNo = Math.max(bestNo, curr.start - currEnd);
                currStart = curr.start;
                currEnd = curr.end;
                bestMilk = Math.max(bestMilk, currEnd-currStart);
            }
        }

        printer.println(bestMilk + " " + bestNo);

        input.close();
        printer.close();
    }
}

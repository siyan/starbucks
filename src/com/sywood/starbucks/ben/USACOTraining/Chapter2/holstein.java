package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 ID: benbli
 LANG: JAVA
 TASK: holstein
 */
public class holstein {
    private static class solution implements Comparable<solution>{
        int count;
        String out;
        public solution(int count, String out){
            this.count = count;
            this.out = out;
        }

        public int compareTo(solution other){
            if(count < other.count) return -1;
            else if(count > other.count) return 1;
            return 0;
        }

        public String toString(){
            return out;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("holstein.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        int V = Integer.parseInt(input.readLine());

        int[] weights = new int[V];

        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < V; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int numScoops = Integer.parseInt(input.readLine());
        int[][] scoops = new int[numScoops][V];


        for (int i = 0; i < numScoops; i++) { //only 15 possible scoops. possible to just do a 2^15 brute force check?
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < V; j++) {
                scoops[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] curr;
        boolean works;
        TreeSet<solution> solves = new TreeSet<solution>();
        for(long i = 1; i < 1 << numScoops; i++){
            curr = new int[V];
            for(int j = 0; j < numScoops; j++){
                if(( (i) & (1<<j)) > 0){
                    for (int k = 0; k < V; k++) {
                        curr[k] += scoops[j][k];
                    }
                }
            }
            //found the sum, check now
            works = true;
            for (int j = 0; j < V; j++) {
                if(curr[j] < weights[j]){
                    works = false;
                    break;
                }
            }
            if(works){
                String ret = Long.bitCount(i) + " ";
                for (int j = 0; j < numScoops; j++) {
                    if(( (i) & (1<<j)) > 0)
                        ret += (j+1) + " ";
                }
                solves.add(new solution(Long.bitCount(i), ret.trim()));
            }
        }
        printer.println(solves.first());
        printer.close();
    }
}

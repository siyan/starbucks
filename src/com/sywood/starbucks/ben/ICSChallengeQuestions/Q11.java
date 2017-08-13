package com.sywood.starbucks.ben.ICSChallengeQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11{
    static int[][] adj;
    static int[] dist;
    static int N;
    static class Pair implements Comparable<Pair>{
        int first, second;
        public Pair(int a, int b) {
            first = a;
            second = b;
        }

        public int compareTo(Pair o) {
            if(o.first == first) return second < o.second ? -1 : 1;
            return first < o.first ? -1 : 1;
        }
    }

    static int sssp(int st, int en) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, st));
        Arrays.fill(dist, 0x3f3f3f);
        dist[st] = 0;
        System.out.println(Arrays.toString(dist));
        while(!pq.isEmpty()) {
            int u = pq.poll().second;
            System.out.println("CURRENTLY AT NODE: " + u);
            for (int v = 0; v < N; v++) {
                if(dist[u]+adj[u][v] < dist[v]){
                    dist[v] = dist[u]+adj[u][v];
                    System.out.println("    ADDING : {" + dist[v] + ", " + v + "} TO THE QUEUE");
                    pq.add(new Pair(dist[v], v));
                }
            }
            System.out.println(Arrays.toString(dist)+"\n");
        }
        System.out.println(Arrays.toString(dist));
        return dist[en];
    }

    public static void main(String[] args){
        N = 5;
        adj = new int[][]{
                {0, 12, 3, 17, 4},
                {39, 0, 48, 2, 6},
                {94, 8, 0, 6, 7},
                {5, 7, 4, 0, 82},
                {9, 23, 5, 20, 0}};
        dist = new int[N];
        System.out.println(sssp(0, 2));
    }
}

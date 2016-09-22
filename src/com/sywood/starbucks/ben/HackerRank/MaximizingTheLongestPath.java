package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Striker on 2016-09-17.
 */
public class MaximizingTheLongestPath {
    private static class DisjointSet{
        int[] p;
        int[] size;
        public DisjointSet(int n) {
            p = new int[n]; size = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = i;
            }
            Arrays.fill(size, 1);
        }
        public int find(int i){
            if (p[i] == i) {
                return i;
            }return p[i] = find(p[i]);
        }
        public void union(int a, int b){
            if (find(a) == find(b)) {
                return;
            }
            size[find(b)] += size[find(a)];
            p[find(a)] = p[b];
        }
        public int getSize(int i){
            return size[find(i)];
        }
    }

    private static class Edge implements Comparable<Edge>{
        int id;
        int _a;
        int _b;
        double _weight;
        private Edge(int id, int a, int b, double w){
            this.id = id;
            _a = a;
            _b = b;
            _weight = w;
        }
        public int compareTo(Edge other){
            return Double.compare(_weight, other._weight);
        }
    }
    private static int headache = 0; // < change this variable depending on weight
    private static ArrayList<Integer> ids = new ArrayList<>();
    private static DisjointSet kruskal(PriorityQueue<Edge> edges, int n){
        DisjointSet process = new DisjointSet(n);
        while (!edges.isEmpty() ) {
            Edge edge = edges.poll();
            if (process.find(edge._a) != process.find(edge._b)) {
                process.union(edge._a, edge._b);
                headache += edge._weight; //this line will change depending on weight.
                ids.add(edge.id);
            }
        }
        return process;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong((input.readLine()));
        PriorityQueue<Edge> q = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for(long i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
        }
    }
}

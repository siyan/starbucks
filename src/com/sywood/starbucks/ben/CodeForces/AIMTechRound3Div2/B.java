package com.sywood.starbucks.ben.CodeForces.AIMTechRound3Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-24.
 */
public class B {
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
        int _a;
        int _b;
        int _weight;
        private Edge(int a, int b, int w){
            _a = a;
            _b = b;
            _weight = w;
        }
        public int compareTo(Edge other){
            return Double.compare(_weight, other._weight);
        }
        public String toString(){
            return ("(" + _a + ", " + _b + ") weight: " + _weight);
        }
    }
    private static long dist = 0; // < change this variable depending on weight
    private static PriorityQueue<Edge> ret = new PriorityQueue<>(Collections.reverseOrder());
    private static long kruskal(PriorityQueue<Edge> edges, int n){
        DisjointSet process = new DisjointSet(n);
        boolean[] visited = new boolean[n];
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (process.find(edge._a) != process.find(edge._b)) {
                process.union(edge._a, edge._b);
                dist += edge._weight; //this line will change depending on weight.
                ret.add(edge);
            }
        }
        return dist;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        st = new StringTokenizer(input.readLine());
        int[] weights = new int[n+1];
        weights[0] = a;
        for (int i = 1; i <= n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] taken = new boolean[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(!taken[i][j] && i != j){
                    taken[i][j] = true;
                    taken[j][i] = true;
                    edges.add(new Edge(i, j, Math.abs(weights[i]-weights[j])));
                }
            }
        }
        System.out.println( (int) (kruskal(edges, n+1)-ret.poll()._weight));
    }
}

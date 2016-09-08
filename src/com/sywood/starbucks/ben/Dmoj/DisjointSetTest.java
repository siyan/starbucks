package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * Created by Ben on 2016-09-05.
 */
public class DisjointSetTest {
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
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(input.readLine());
            edges.add(new Edge(i, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, i));
        }
        DisjointSet ret = kruskal(edges, N);
        if (ret.getSize(0) < N){
            System.out.println("Disconnected Graph");
        }else{
            for(int id : ids){
                System.out.println(id);
            }
        }
    }
}

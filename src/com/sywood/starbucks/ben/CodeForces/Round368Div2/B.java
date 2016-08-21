package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class B {
    static class Edge implements Comparable<Edge>{
        int a;
        int w;
        public Edge(int a, int w){
            this.a = a;
            this.w = w;
        }

        public int compareTo(Edge edge) {
            return Integer.compare(w, edge.w);
        }
        public String toString(){
            return ("(" + a + ", " + w + ")");
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] lst = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lst[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            lst[a].add(new Edge(b, w));
            lst[b].add(new Edge(a, w));
        }

        int[] storage = new int[k];
        boolean[] isStorage = new boolean[n];
        if (k > 0) {
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < k; i++) {
                storage[i] = Integer.parseInt(st.nextToken()) - 1;
                isStorage[storage[i]] = true;
            }


            int best = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                for (Edge adj : lst[storage[i]]) {
                    if (!isStorage[adj.a])
                        best = Math.min(best, adj.w);
                }
            }
            if (best < Integer.MAX_VALUE) {
                System.out.println(best);
            } else {
                System.out.println(-1);
            }
        }else{
            System.out.println(-1);
        }
    }
}

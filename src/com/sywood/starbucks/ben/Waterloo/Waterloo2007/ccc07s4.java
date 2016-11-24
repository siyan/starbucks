package com.sywood.starbucks.ben.Waterloo.Waterloo2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc07s4 {
    static int[] memo;
    static ArrayList<Integer>[] matrix;
    static int dfs(boolean visited[], int curr){
        visited[curr] = true;
        if(matrix[curr].isEmpty()) memo[curr] = 1;
        boolean allVisited = true;
        int count = 0;
        if(memo[curr] != -1) return memo[curr];

        for(int node : matrix[curr]){
            if(!visited[node]){
                visited[node] = true;
                count += dfs(visited, node);
                allVisited = false;
                visited[node] = false;
            }
        }

        if (allVisited)
            return 1;

        return memo[curr] = count;
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        int n = input.nextInt();
        matrix = new ArrayList[n];
        memo = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
            memo[i] = -1;
        }

        int a = input.nextInt(), b = input.nextInt();
        for(; a != 0 && b != 0; a = input.nextInt(), b = input.nextInt()){
            matrix[a-1].add(b-1);
        }
        boolean[] visited = new boolean[n];
        if(matrix[0].isEmpty()) System.out.println(0);
        else System.out.println(dfs(visited, 0));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i){
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if (st.hasMoreTokens()){
                return st.nextToken();
            }else{
                st = new StringTokenizer(br.readLine());
            }
            return next();
        }
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        public String readLine() throws IOException{
            return br.readLine();
        }
    }
}

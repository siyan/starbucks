package com.sywood.starbucks.ben.COCI.ThirdQuestion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int matrix[][], K, N;
    private static boolean visited[];

    static int min(int a, int b){
        return a > b ? b : a;
    }
    private static int dfs(int notVisited, int node, int best){
        if(notVisited == K) {
            return best;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if(!visited[i] && i != node){
                visited[i] = true;
                min = min(min, dfs(notVisited-1, i, best+matrix[node][i]));
                visited[i] = false;
            }
        }
        return min;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        K = Integer.parseInt(data[1]);

        matrix = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            data = input.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(data[j]);
            }
        }
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            best = min(best, dfs(N, i, 0));
            visited[i] = false;
        }
        System.out.println(best);
    }
}

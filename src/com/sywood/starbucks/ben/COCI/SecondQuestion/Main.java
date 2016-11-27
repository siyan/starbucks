package com.sywood.starbucks.ben.COCI.SecondQuestion;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by Ben on 2016-11-26.
 */
public class Main {
    private static char min(char a, char b){
        return a > b ? b : a;
    }
    private static int N, M;
    private static char[][] matrix;
    static int dr[] = new int[]{1, 0};
    static int dc[] = new int[]{0, 1};
    static boolean[][] visited;
    static String min;

    static String min(String a, String b){
        return a.compareTo(b) < 0 ? a : b;
    }

    private static String dfs(String curr, int row, int col){
        //System.out.println(curr);
        if(row == N-1 && col == M-1)
            return curr + matrix[row][col];
        curr += matrix[row][col];
        for (int i = 0; i < 2; i++) {
            if(row + dr[i] >= 0 && row+dr[i] < N && col+dc[i] >= 0 && col + dc[i] < M) {
                visited[row+dr[i]][col+dc[i]] = true;
                String t =  dfs(curr, row + dr[i], col + dc[i]);
                //if(min(min, t).equals(t)) System.out.println(min + ", " + t);
                min = min(min, t);
            }
        }
        return min;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = input.readLine().toCharArray();
        }
        min = "";
        for (int i = 0; i < N + M; i++) {
            min += "z";
        }
        visited = new boolean[N][M];
        //System.out.println(min("pohlepko", "pohlepoo"));
        System.out.println(dfs("", 0, 0));

    }
}

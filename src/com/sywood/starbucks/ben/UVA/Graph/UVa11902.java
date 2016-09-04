package com.sywood.starbucks.ben.UVA.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * dfs example question
 */
public class UVa11902 {

    private static boolean[] visited;
    private static boolean[][] matrix;

    private static void dfs(int current, int ignore){
        if (current == ignore)
            return; //ignore the node

        visited[current] = true;

        for(int i = 0; i < visited.length; i++)
            if(matrix[current][i] && !visited[i])
                dfs(i, ignore);

    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(input.readLine());
            matrix = new boolean[N][N];
            boolean[][] dominate = new boolean[N][N];
            visited = new boolean[N];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = (Integer.parseInt(st.nextToken()) == 1);
                }
            }

            dfs(0, -1);

            boolean[] reachable = visited.clone();

            for (int i = 0; i < N; i++) {
                visited = new boolean[N];
                dfs(0, i);
                for (int j = 0; j < N; j++) {
                    if(reachable[j] && !visited[j])
                        dominate[i][j] = true;
                }
            }

            System.out.println("Case " + t + ":");
            String ln = "+";
            for (int i = 0; i < 2*N-1; i++) {
                ln += "-";
            }
            ln += "+";

            System.out.println(ln);
            for (int i = 0; i < N; i++) {
                System.out.print("|");
                for (int j = 0; j < N; j++) {
                    System.out.print(dominate[i][j] ? "Y" : "N");
                    System.out.print("|");
                }
                System.out.println("\n" + ln);
            }
        }
    }
}

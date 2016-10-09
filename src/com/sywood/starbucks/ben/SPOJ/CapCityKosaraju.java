package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-10-08.
 */
public class CapCityKosaraju {
    private static ArrayList<Integer>[] lst;
    private static ArrayList<Integer>[] tLst;
    private static int N;
    private static int[] group;
    private static boolean[] visited;
    private static ArrayList<Integer> stk = new ArrayList<>();

    static void dfs1(int S){
        visited[S] = true;

        for(int i : lst[S]){
            if(!visited[i]){
                dfs1(i);
            }
        }
        stk.add(S);
    }

    static void dfs2(int S, int c){
        visited[S] = false;
        group[S] = c;
        for(int i : tLst[S]){
            if(visited[i]){
                dfs2(i, c);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lst = new ArrayList[N];
        tLst = new ArrayList[N];
        int[] inDeg = new int[N];
        group = new int[N];

        for (int i = 0; i < N; i++) {
            lst[i] = new ArrayList<>();
            tLst[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            lst[a].add(b);
            tLst[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                dfs1(i);
            }
        }
        int color = 0;
        for(int i = stk.size()-1; i >= 0; i--){
            if(visited[stk.get(i)]){
                dfs2(stk.get(i), color++);
            }
        }
        int max = color;
        for (int i = 0; i < N; i++) {
            for(int j : lst[i]){
                if(group[i] != group[j]){
                    inDeg[i] += 1;
                }
            }
        }

        System.out.println(stk);

    }
}

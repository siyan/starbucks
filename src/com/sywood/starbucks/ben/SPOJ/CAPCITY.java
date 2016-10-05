package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class CAPCITY {
    private static ArrayList<Integer>[] lst, invLst;
    private static Stack<Integer> stk = new Stack<>();
    private static boolean visited[];

    void dfs1(int v){
        visited[v] = true;

        for(int i : lst[v]){
            if(!visited[i])
                dfs1(i);
        }
        stk.push(v);
    }

    void dfs2(int v, int c){
        visited[v] = false;

    }



    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int a, b;
        visited = new boolean[N];
        lst = new ArrayList[N];
        invLst = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lst[i] = new ArrayList<>();
            invLst[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            data = input.readLine().split(" ");
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            lst[a].add(b);
            invLst[b].add(a);

        }

    }
}

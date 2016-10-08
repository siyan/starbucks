package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class CAPCITY {
    private static ArrayList<Integer>[] lst, invLst;
    private static Stack<Integer> stk = new Stack<>();
    private static boolean visited[];
    private static int colors[];

    private static void dfs1(int v){
        visited[v] = true;

        for(int i : lst[v]){
            if(!visited[i])
                dfs1(i);
        }
        stk.push(v);
    }

    private static void dfs2(int v, int c){
        visited[v] = false;
        colors[v] = c;

        for(int i : invLst[v]){
            if(visited[i]){
                dfs2(i, c);
            }
        }
    }



    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int a, b;
        visited = new boolean[N];
        colors = new int[N];
        int[] in = new int[N];
        lst = new ArrayList[N];
        invLst = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lst[i] = new ArrayList<>();
            invLst[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            data = input.readLine().split(" ");
            a = Integer.parseInt(data[0])-1;
            b = Integer.parseInt(data[1])-1;
            lst[a].add(b);
            invLst[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                dfs1(i);
            }
        }
        int color = 0;
        while(!stk.isEmpty()){
            int curr = stk.pop();
            if(visited[curr]){
                dfs2(curr, color++);
            }
        }
        int limit = color;
        for (int i = 0; i < N; i++) {
            for(int j : lst[i]){
                if(colors[i] != colors[j]){
                    in[colors[j]] += 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < limit; i++){
            if(in[i] == 1)
                count++;
        }
        if( count > 1)
            System.out.println(0);
        else{
            count = 0;
            for(int i = 0; i < N; i++){
                if (in[colors[i]] == 0){
                    count++;
                }
            }
            System.out.println(count);
            for(int i = 0; i < N; i++){
                if(in[colors[i]] == 0){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}

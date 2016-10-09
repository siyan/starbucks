package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CapCityTarjans {
    private static ArrayDeque<Integer> stk = new ArrayDeque<>();
    private static int[] pre; //of size N
    private static int[] low; //lowlink list
    private static ArrayList<Integer>[] lst;
    private static int idcount;
    private static int N;
    private static ArrayList<PriorityQueue<Integer>> sccs = new ArrayList<>();

    static void dfs(int i){

        pre[i] = idcount++;
        low[i] = pre[i];
        stk.push(i);

        for(int j : lst[i]){
            if (pre[j] == 0) {
                dfs(j);
                low[i] = Math.min(low[i], low[j]);
            }else if (stk.contains(j)){
                low[i] = Math.min(low[i], low[j]);
            }
        }
        if (low[i] == pre[i]){
            PriorityQueue<Integer> scc = new PriorityQueue<>();
            while(stk.peek() != i){
                scc.add(stk.pop());
            }
            scc.add(stk.pop());
            sccs.add(scc);
            idcount = sccs.size()+1;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lst = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lst[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            lst[a].add(b);
        }
        pre = new int[N];
        low = new int[N];
        idcount = 1;

        for (int i = 0; i < N; i++) {
            if(pre[i] == 0)
                dfs(i);
        }

        boolean include[] = new boolean[sccs.size()];
        int total = N;
        for (int i = 0; i < N; i++) {
            for (int j : lst[i]) {
                if (low[i] != low[j]) {
                    total -= 1;
                    include[low[i]-1] = true;
                    break;
                }
            }
        }

        String ret;
        System.out.println(total);
        for (int i = 0; i < sccs.size(); i++) {
            ret = "";
            if (!include[i]) {
                while (!sccs.get(i).isEmpty()) {
                    ret += (sccs.get(i).poll()+1) + " ";
                }
                System.out.println(ret.trim());
            }

        }

    }
}

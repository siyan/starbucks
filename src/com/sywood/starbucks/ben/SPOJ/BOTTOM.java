package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Ben on 2016-10-06.
 */
public class BOTTOM {
    private static Stack<Integer> stk = new Stack<>();
    private static int[] pre; //of size N
    private static int[] low; //lowlink list
    private static ArrayList<Integer>[] lst;
    private static int idcount;
    private static ArrayList<ArrayList<Integer>> sccs;

    static void dfs(int i){

        pre[i] = idcount++;
        low[i] = pre[i];
        stk.push(i);
        for(int j : lst[i]){
            if (pre[j] == -1) {
                dfs(j);
                low[i] = Math.min(low[i], low[j]);
            }else if (stk.contains(j)){
                low[i] = Math.min(low[i], low[j]);
            }
        }
        if (low[i] == pre[i]){
            ArrayList<Integer> scc = new ArrayList<>();
            low[i] = sccs.size();
            while(stk.peek() != i){
                low[stk.peek()] = sccs.size();
                scc.add(stk.pop());
            }
            scc.add(stk.pop());
            sccs.add(scc);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int V = Integer.parseInt(st.nextToken());
        while(V > 0) {
            int E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(input.readLine());
            lst = new ArrayList[V];
            sccs  = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                lst[i] = new ArrayList<>();
            }
            pre = new int[V];
            Arrays.fill(pre, -1);
            low = new int[V];
            idcount = 0;
            for (int i = 0; i < E; i++) {
                lst[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1);
            }
            for (int i = 0; i < V; i++) {
                if(pre[i] == -1)
                    dfs(i);
            }

            boolean[] include = new boolean[sccs.size()];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(i != j && low[i] != low[j] && lst[i].contains(j)){
                        include[low[i]] = true;
                    }
                }
            }
            String ret = "";

            for (int i = 0; i < V; i++) {
                if(!include[low[i]]){
                    ret += (i+1) + " ";
                }
            }
            printer.println(ret.trim());

            st = new StringTokenizer(input.readLine());
            V = Integer.parseInt(st.nextToken());
        }
        printer.close();
    }
}

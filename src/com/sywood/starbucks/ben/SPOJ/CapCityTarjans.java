package com.sywood.starbucks.ben.SPOJ;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ben on 2016-10-06.
 */
public class CapCityTarjans {
    private static Stack<Integer> stk = new Stack<>();
    static int[] pre = new int[3]; //must be same size as matrix, store # of edges.
    static int[] low = new int[3]; //lowlink list
    static int[][] matrix;
    static int idcount;
    static ArrayList<ArrayList<Integer>> sccs = new ArrayList<>();
    void dfs(int i){
        stk.push(i);
        pre[i] = idcount++;
        low[i] = pre[i];
        for(int j : matrix[i]){
            if (pre[j] == -1){
                dfs(j);
            }
            low[j] = Math.min(low[i], low[j]);
        }
        if (low[i] == pre[i]){
            ArrayList<Integer> scc = new ArrayList<>();
            while(stk.peek() != i){
                int j = stk.pop();
                scc.add(j);
            }
            scc.add(stk.pop());
            sccs.add(scc);
        }
    }
}

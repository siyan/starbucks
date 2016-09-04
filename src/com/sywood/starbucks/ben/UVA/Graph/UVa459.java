package com.sywood.starbucks.ben.UVA.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ben on 2016-09-03.
 */
public class UVa459 {
    static boolean[] matrix;
    static ArrayList<Integer>[] edges;

    private static void dfs(int current){
        for(int node : edges[current]){
            if(!matrix[node]){
                matrix[node] = true;

                dfs(node);

            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(input.readLine());
        input.readLine();

        String line;

        for(int t = 1; t <= T; t++){

            int max = input.readLine().charAt(0)-'A'+1;

            matrix = new boolean[max];

            edges = new ArrayList[max];
            for(int i = 0; i < max; i++){
                edges[i] = new ArrayList<>();
            }

            line = input.readLine();

            while(line != null && !line.equals("")){
                int a = line.charAt(0)-'A';
                int b = line.charAt(1)-'A';

                edges[a].add(b);
                edges[b].add(a);
                line = input.readLine();
            }

            int counter = 0;

            for(int i = 0; i < max; i++){
                if(!matrix[i]){
                    counter++;
                    dfs(i);
                }
            }

            System.out.println(counter);
            if (t < T)
                System.out.println();
        }

    }
}

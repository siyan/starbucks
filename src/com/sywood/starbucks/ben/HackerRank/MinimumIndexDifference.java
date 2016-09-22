package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Striker on 2016-09-17.
 */
public class MinimumIndexDifference {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        HashMap<Integer, Integer> a = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            a.put(Integer.parseInt(st.nextToken()), i);
        }
        HashMap<Integer, Integer> b = new HashMap<>();
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            b.put(Integer.parseInt(st.nextToken()), i);
        }

        int minIdx = Integer.MAX_VALUE;
        int minNum = Integer.MAX_VALUE;

        for(int key : a.keySet()){
            int idx = Math.abs(a.get(key)- b.get(key));
            if (minIdx > idx){
                minNum = key;
                minIdx = idx;
            }else if (minIdx == idx){
                minIdx = Math.min(minIdx, idx);
            }
        }

        System.out.println(minNum);

    }
}

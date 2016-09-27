package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-24.
 */
public class SockMerchant {
    public static void main(String[] arg)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] values = new int[n];
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            if (!frequencies.containsKey(values[i])){
                frequencies.put(values[i], 1);
            }else{
                frequencies.put(values[i], frequencies.get(values[i])+1);
            }
        }
        int pairs = 0;
        for(int key : frequencies.keySet()){
            pairs += frequencies.get(key)/2;
        }
        System.out.println(pairs);
    }
}

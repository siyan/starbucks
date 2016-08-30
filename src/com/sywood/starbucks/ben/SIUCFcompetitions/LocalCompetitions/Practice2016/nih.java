package com.sywood.starbucks.ben.SIUCFcompetitions.LocalCompetitions.Practice2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Ben on 2016-08-28.
 */
public class nih {
    private static class Disease{
        TreeMap<Integer, Integer> data;
        public Disease(String[] input){
            data = new TreeMap<>();
            for(int i = 0; i < input.length/2; i++){
                data.put(Integer.parseInt(input[i]), Integer.parseInt(input[i+1]));
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = input.readLine().split(" ");
            int d = Integer.parseInt(data[0]);
            int B = Integer.parseInt(data[1]);
            ArrayList<Disease> diseases = new ArrayList<>();

        }
    }
}

package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Second TreeMap question
 */
public class UVa11286 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine()), course;
        while(n != 0){
            TreeMap<String, Integer> courses = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String[] parts = input.readLine().split(" ");
                Arrays.sort(parts);
                String id = Arrays.toString(parts);

                if (!courses.containsKey(id))
                    courses.put(id, 1);
                else
                    courses.put(id, courses.get(id) + 1);
            }
            int max = 0;
            for(int value : courses.values()){
                max = Math.max(max, value);
            }

            int taken = 0;
            for(int value : courses.values()){
                if (value == max)
                    taken += value;
            }
            System.out.println(taken);
            n = Integer.parseInt(input.readLine());
        }
    }
}

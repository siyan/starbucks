package com.sywood.starbucks.ben.Waterloo.Waterloo2007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


/**
 doing much, much later
 */
public class ccc07j5 {
    private static ArrayList<Integer> motels = new ArrayList<>();
    private static int min, max;
    private static int ways = 0;
    private static int[] memo = new int[7000];

    private static void recurse(int dist){
        if(7000 <= dist) {
            ways++;
        }else {

            for(int motel : motels){
                if(motel - dist >= min && motel-dist <= max)
                    recurse(motel);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] init = "0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000".split(", ");
        for (int i = 0; i < init.length; i++) {
            motels.add(Integer.parseInt(init[i]));
        }
        min = Integer.parseInt(input.readLine());
        max = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            motels.add(Integer.parseInt(input.readLine()));
        }
        Collections.sort(motels);
        recurse(0);
        System.out.println(ways);

    }
}

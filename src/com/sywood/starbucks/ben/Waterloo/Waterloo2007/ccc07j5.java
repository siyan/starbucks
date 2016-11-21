package com.sywood.starbucks.ben.Waterloo.Waterloo2007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Created by Ben on 2016-11-20.
 */
public class ccc07j5 {
    private static ArrayList<Integer> motels = new ArrayList<>();

    private static int recurse(int idx, int dist){
        if(dist >= 7000) return 1;

        return 1;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] init = "0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000".split(", ");
        for (int i = 0; i < init.length; i++) {
            motels.add(Integer.parseInt(init[i]));
        }
        System.out.println(motels);
        int min = Integer.parseInt(input.readLine());
        int max = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            motels.add(Integer.parseInt(input.readLine()));
        }
        Collections.sort(motels);

    }
}

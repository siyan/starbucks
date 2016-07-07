package com.sywood.starbucks.ben.SIUCFcompetitions.SecondPreCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class excellence {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(scores);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < scores.length / 2; i++) {
            int temp = scores[i] + scores[(scores.length-1)-i];
            min = Math.min(min,temp);
        }
        System.out.println(min);
    }
}

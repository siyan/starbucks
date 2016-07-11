package com.sywood.starbucks.ben.SIUCFcompetitions.FirstCompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class max {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Integer.parseInt(input.readLine()));
        }
        System.out.println(max);
    }
}
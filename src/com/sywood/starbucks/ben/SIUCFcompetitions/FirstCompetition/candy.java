package com.sywood.starbucks.ben.SIUCFcompetitions.FirstCompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class candy {
    private static int k;
    private static int[] candies;
    private static int dp(){
        int tot = 0;
        for (int i = 0; i < k; i++) {
            int max = 0;
            int idx = -1;
            for (int j = 0; j < candies.length; j++) {
                if (max < candies[j]/2){
                    max = candies[j]/2;
                    idx = j;
                }
            }
            tot += max;
            candies[idx] /= 2;
        }
        return tot;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] info = input.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        k = Integer.parseInt(info[1]);
        candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = Integer.parseInt(input.readLine());
        }
        System.out.println(dp());
    }
}

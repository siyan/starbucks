package com.sywood.starbucks.ben.SIUCFcompetitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-12-03.
 */
public class virtual {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = input.readLine().split(" ");
            int b = Integer.parseInt(data[0]);
            int p = Integer.parseInt(data[1]);
            int t = Integer.parseInt(data[2]);
            int timePassed = 0;
            int playTime = 0;
            while(playTime < t){
                playTime += p;
                if(playTime < t) {
                    timePassed += b;
                }
            }
            timePassed += t;
            System.out.println(timePassed);
        }
    }
}

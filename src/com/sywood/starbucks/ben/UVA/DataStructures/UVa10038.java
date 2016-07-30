package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * first underlined data structure question.
 */
public class UVa10038 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while(line != null && !line.equals("")){
            String[] data = line.split(" ");
            int n = Integer.parseInt(data[0]);
            boolean[] yes = new boolean[n-1];
            int start = Integer.parseInt(data[1]);
            for (int i = 2; i < data.length; i++) {
                int diff = Integer.parseInt(data[i]);
                diff = Math.abs(diff-start)-1;
                start = Integer.parseInt(data[i]);
                if (diff >= 0 && diff < n-1){
                    yes[diff] = true;
                }
            }
            boolean[] temp = new boolean[n-1];
            Arrays.fill(temp, true);
            if (!Arrays.equals(temp, yes)){
                System.out.println("Not jolly");
            }else{
                System.out.println("Jolly");
            }
            line = input.readLine();
        }
    }
}

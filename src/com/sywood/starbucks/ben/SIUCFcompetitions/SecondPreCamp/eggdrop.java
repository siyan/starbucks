//package com.sywood.starbucks.ben.SIUCFcompetitions.SecondPreCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class eggdrop {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        String[] cond = new String[k];
        for (int i = 0; i < n; i++) {
            String[] data = input.readLine().split(" ");
            cond[Integer.parseInt(data[0])-1] = data[1];
        }
        int max = 1; // max floor where it won't break
        int min = k; // min floor where it will break
        for (int i = 0; i < k; i++) {
            if (cond[i] != null) {
                if (cond[i].equals("BROKEN") && max > 1) {
                    max = i;
                    break;
                }else{
                    max = i+1;
                }
            }
        }
        for (int i = 0; i < k; i++){
            if (cond[i] != null) {
                if (cond[i].equals("SAFE")) {
                    min = i + 2;
                }
            }
        }
        if (min > k){
            min = k;
        }
        if (max < 1){
            max = 1;
        }
        System.out.printf("%d %d\n", min, max);
    }
}

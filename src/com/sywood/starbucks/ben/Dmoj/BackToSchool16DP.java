package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class BackToSchool16DP {
    static class Score implements Comparable<Score>{
        int[] scores;
        int len;
        public Score(String[] inp){
            len = inp.length;
            scores = new int[len];
            for (int i = 0; i < len; i++) {
                scores[i] = Integer.parseInt(inp[i]);
            }
        }

        public int compareTo(Score o){
            boolean equal = true;
            for (int i = 0; i < len; i++) {
                if(o.scores[i] > scores[i]) return 1;
                if(o.scores[i] < scores[i]){
                    equal = false;
                    break;
                }
            }
            if(equal) return 0;
            return -1;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int P = Integer.parseInt(data[0]);
        int Q = Integer.parseInt(data[1]);
        int N = Integer.parseInt(data[2]);

       // Score[] scores = new Score[N];
        int[] betterThan = new int[N];
        TreeMap<Score, Integer> scores = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            Score curr = new Score(input.readLine().split(" "));
            if(scores.containsKey(curr)){
                scores.put(curr, scores.get(curr)+1);
            }else{
                scores.put(curr, 1);
            }
        }


    }
}

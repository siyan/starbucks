package com.sywood.starbucks.ben.SIUCFcompetitions.TestCompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class polling {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        HashMap<String, Integer> votes = new HashMap<>();
        ArrayList<String> best = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++){
            String name = input.readLine();
            if (!votes.containsKey(name)){
                votes.put(name, 0);
            }else{
                int temp = votes.get(name);
                votes.remove(name);
                votes.put(name, temp+1);
            }
        }
        for (String key : votes.keySet()){
            max = Math.max(max, votes.get(key));
        }
        for (String key : votes.keySet()){
            if (votes.get(key) == max){
                best.add(key);
            }
        }
        Collections.sort(best);
        for (String name : best){
            System.out.println(name);
        }
    }
}

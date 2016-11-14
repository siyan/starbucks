package com.sywood.starbucks.ben.Waterloo.Waterloo2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ccc00s2 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine().trim());

        ArrayList<Integer> streams = new ArrayList<>();

        for(int i = 0; i < n; i++) streams.add(Integer.parseInt(input.readLine().trim()));

        int command;
        for(command = Integer.parseInt(input.readLine().trim()); command != 77; command = Integer.parseInt(input.readLine().trim())){
            if(command == 99){
                int target = Integer.parseInt(input.readLine().trim())-1;
                int percent = Integer.parseInt(input.readLine().trim());
                int hold = streams.get(target);
                streams.set(target, streams.get(target)*percent/100);
                streams.add(target+1, hold-streams.get(target));
            }else{
                int target = Integer.parseInt(input.readLine().trim())-1;
                streams.set(target+1, streams.get(target) + streams.get(target+1));
                streams.remove(target);
            }
        }
        String ret = "";
        for(int stream : streams)
            ret += stream + " ";
        System.out.println(ret.trim());
    }
}

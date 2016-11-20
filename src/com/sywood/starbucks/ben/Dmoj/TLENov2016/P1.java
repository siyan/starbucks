package com.sywood.starbucks.ben.Dmoj.TLENov2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Ben on 2016-11-17.
 */
public class P1 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> count = new HashMap<>();
        int N = Integer.parseInt(input.readLine());

        for(int i = 0; i < N; i++){
            String line = input.readLine();
            if(!count.containsKey(line)){
                count.put(line, 1);
            }else{
                count.put(line, count.get(line)+1);
            }
        }

        int counter = 0;
        for(String key : count.keySet()){
            if(count.get(key) == 1) counter++;
        }
        System.out.println(counter);
    }
}

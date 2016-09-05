package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * First underlined TreeSet problem
 */

public class UVa10226 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int T = Integer.parseInt(input.readLine());
        input.readLine();
        for(int t = 1; t <= T; t++){
            TreeMap<String, Integer> trees = new TreeMap<>();

            line = input.readLine();

            double counter = 0;

            while(!line.equals("")){

                if (trees.containsKey(line))
                    trees.put(line, trees.get(line)+1);
                else
                    trees.put(line, 1);

                counter++;
                line = input.readLine();
            }

            for(String key : trees.keySet()){
                System.out.printf("%s %.04f\n", key, trees.get(key)/counter*100);
            }
            if (t < T-1)
                System.out.println();
        }

    }
}

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

            int counter = 0;

            while(!line.equals("")){

                if (trees.containsKey(line))
                    trees.put(line, trees.get(line)+1);
                else
                    trees.put(line, 0);

                counter++;
                line = input.readLine();
            }


        }

    }
}

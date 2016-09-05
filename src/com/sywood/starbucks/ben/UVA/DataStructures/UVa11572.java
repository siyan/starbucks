package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * third underlined treemap question
 */
public class UVa11572 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for(int t = 1; t <= n; t++){
            int numSnow = Integer.parseInt(input.readLine());
            TreeMap<Integer, Integer> snowflakes = new TreeMap<>();

            int start = 0, max = 0;

            for(int i = 1; i <= numSnow; i++) {
                int snowflake = Integer.parseInt(input.readLine());

                if(snowflakes.containsKey(snowflake)){
                    int position = snowflakes.get(snowflake);

                    if (position >= start)
                        start = position;

                    max = Math.max(max, i - start);
                    snowflakes.put(snowflake, i);
                }else{
                    snowflakes.put(snowflake, i);
                    max = Math.max(max, i - start);
                }
            }

            System.out.println(max);
        }
    }
}

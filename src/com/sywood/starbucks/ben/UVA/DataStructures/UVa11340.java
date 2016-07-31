package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Second underlined basic data structures question
 */
public class UVa11340 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        int K = Integer.parseInt(input.readLine());
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(input.readLine());
            for (int j = 0; j < n; j++) {
                String[] data = input.readLine().split(" ");
                map.put(data[0].charAt(0), Integer.parseInt(data[1]));
            }
            int k = Integer.parseInt(input.readLine());
            double sum = 0;
            for (int j = 0; j < k; j++) {
                String line = input.readLine();
                for (char let : line.toCharArray()) {
                    if (map.containsKey(let)) {
                        sum += map.get(let);
                    }
                }
            }
            sum /= 100;
            System.out.printf("%.2f$\n", sum);
            map.clear();
        }
    }
}

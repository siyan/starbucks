package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 Minimum representation

 a b
 d c

 make it a map <int, int> make each key the id of the last row, and then the next part is the count
 eliminate all ones in anything but the last row and column
 */
public class ocanada {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int G = Integer.parseInt(input.readLine());
        HashMap<Integer, Integer> grid = new HashMap<>();
        boolean box[][] = new boolean[G][G];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < G; j++) {
                char[] data = input.readLine().toCharArray();
                for (int k = 0; k < G; k++) {
                    box[j][k] = data[k] == 'R';
                }
            }
            for (int j = 0; j < G - 1; j++) {
                for (int k = 0; k < G - 1; k++) {
                    if(box[j][k]){
                        box[j][k] = false;
                        box[j+1][k] = !box[j+1][k];
                        box[j+1][k+1] = !box[j+1][k+1];
                        box[j][k+1] = !box[j][k+1];
                    }
                }
            }
            //made one box
            //process each bottom line
            int key = 0;
            int count = 0;
            for (int j = 0; j < G; j++) {
                key += (box[G-1][j] ? 1 : 0)<<count++;
            }
            for(int j = G-2; j >= 0; j--){
                key += (box[j][G-1] ? 1 : 0)<<count++;
            }
            if(grid.containsKey(key)) grid.put(key, grid.get(key)+1);
            else grid.put(key, 0);
        }
        int tot = 0;
        for(int val : grid.values())
            tot += val;
        System.out.println(tot);
    }
}

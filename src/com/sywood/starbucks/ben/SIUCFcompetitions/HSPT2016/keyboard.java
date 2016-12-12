package com.sywood.starbucks.ben.SIUCFcompetitions.HSPT2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class keyboard {
    private static HashMap<String, Integer> keys = new HashMap<>();

    private static void generate(){
        keys.put("C", 4);
        keys.put("C#", 5);
        keys.put("Db", 5);
        keys.put("D", 6);
        keys.put("D#", 7);
        keys.put("Eb", 7);
        keys.put("E", 8);
        keys.put("F", 9);
        keys.put("F#", 10);
        keys.put("Gb", 10);
        keys.put("G", 11);
        keys.put("G#", 12);
        keys.put("Ab", 12);
        keys.put("A", 1);
        keys.put("A#", 2);
        keys.put("Bb", 2);
        keys.put("B", 3);
    }
    private static int min(int a, int b){
        return a < b ? a : b;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(input.readLine());
        generate();
        for(int s = 1; s <= S; s++){
            String[] data = input.readLine().split(" ");
            //will be at most 12.
            int k = Integer.parseInt(data[0]);
            int steps = 0;
            for(int i = 2; i <= k; i++){
                int note1 = keys.get(data[i-1]);
                int note2 = keys.get(data[i]);
                if(note1 != note2){
                    System.out.println((note1+note2)%12 + ", " + (12+note1-note2)%12);
                    if(note1 == 11 && note2 == 1 || note1 == 1 && note2 == 11) steps += 2;
                    else steps += min((note1+note2)%12, (12+note1-note2)%12);
                }
            }
            System.out.println("Song #" + s + ": " + steps);
        }
    }
}

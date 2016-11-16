package com.sywood.starbucks.ben.Waterloo.Waterloo2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ben on 2016-11-15.
 */
public class ccc01s1 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character>[] cards = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            cards[i] = new ArrayList<>();
        }
        char[] line = input.readLine().toCharArray();
        String[] lazy = new String[]{"Clubs ", "Diamonds ", "Hearts ", "Spades "};
        HashMap<Character, Integer> suit = new HashMap<>();
        suit.put('C', 0);
        suit.put('D', 1);
        suit.put('H', 2);
        suit.put('S', 3);
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('A', 4);
        values.put('K', 3);
        values.put('Q', 2);
        values.put('J', 1);
        int[] points = new int[4];
        int currSuit = suit.get(line[0]);
        for (int i = 1; i < line.length; i++) {
            if(suit.containsKey(line[i])) currSuit = suit.get(line[i]);
            else{
                if(values.containsKey(line[i]))points[currSuit] += values.get(line[i]);
                cards[currSuit].add(line[i]);
            }
        }
        for (int i = 0; i < 4; i++) {
            if(cards[i].isEmpty()) points[i] = 3;
            else if (cards[i].size() == 1) points[i] = 2;
            else if (cards[i].size() == 2) points[i] = 1;
        }
        System.out.println("Cards dealt              Points");
        for (int i = 0; i < 4; i++) {
            System.out.print(lazy[i]);

        }
    }
}

package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ben on 2016-09-24.
 */
public class TwoCharacters {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> chars = new ArrayList<>();
        int len = Integer.parseInt(input.readLine());
        String st = input.readLine();
        for (int i = 0; i < len; i++) {
            if (!chars.contains(st.charAt(i)))
                chars.add(st.charAt(i));
        }
        int best = 0;
        for (int i = 0; i < (1<<chars.size()); i++) {
            if (Integer.bitCount(i) == chars.size()-2){
                String temp = st;
                for (int j = 0; j < chars.size(); j++) {
                    if ((i & (1<<j)) > 0)
                        temp = temp.replaceAll(String.valueOf(chars.get(j)), "");
                }
                boolean good = true;
                for (int j = 1; j < temp.length(); j++) {
                    if (temp.charAt(j-1) == temp.charAt(j)){
                        good = false;
                        break;
                    }
                }
                if(good) {
                    best = Math.max(best, temp.length());
                }
            }
        }
        System.out.println(best);
    }
}

package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class UVa481 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        String line = input.readLine();
        while(line != null && !line.equals("")){
            numbers.add(Integer.parseInt(line));
            line = input.readLine();
        }
        Collections.sort(sorted);


    }
}

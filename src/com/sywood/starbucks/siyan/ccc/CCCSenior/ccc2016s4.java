package com.sywood.starbucks.siyan.ccc.CCCSenior;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc2016s4 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(input.readLine());
        ArrayList<Integer> rice = new ArrayList<>();
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < size; i++) {
            rice.add(Integer.parseInt(st.nextToken()));
        }
    }
}

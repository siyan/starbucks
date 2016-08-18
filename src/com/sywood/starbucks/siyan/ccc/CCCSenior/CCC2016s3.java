package com.sywood.starbucks.siyan.ccc.CCCSenior;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CCC2016s3 {
    static ArrayList<Integer>[] list;

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int a,b;
        ArrayList<Integer> restaurants = new ArrayList<>();
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; i++) {
            restaurants.add(Integer.parseInt(st.nextToken()));
        }
        list = new ArrayList[N];
        Arrays.fill(list, new ArrayList<Integer>());
        for (int i = 0; i < N-1; i++) {
            data = input.readLine().split(" ");
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            list[a].add(b);
        }

    }
}

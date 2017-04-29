package com.sywood.starbucks.ben.Dmoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class t {
    public static void main(String[] args)throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);
        int D = Integer.parseInt(data[2]);
        ArrayList<Integer>[] jacks = new ArrayList[K+1];
        for (int i = 0; i < K+1; i++) {
            jacks[i] = new ArrayList<>();
        }
        int currIdx = 0;
        long total = 1;
        for(int n = 0; n < N; n++){
            data = input.readLine().split(" ");
            if(data[0].equals("T")) currIdx++;
            else{
                jacks[currIdx].add(Integer.parseInt(data[1]));
                total *= Integer.parseInt(data[1]);
            }
        }
        for (int i = 0; i < K; i++) {
            for(int divide : jacks[i]) total /= divide;
            if(total > D) System.out.println("dust");
            else
            System.out.println(total);
        }
    }
}

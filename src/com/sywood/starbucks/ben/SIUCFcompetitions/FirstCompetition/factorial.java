package com.sywood.starbucks.ben.SIUCFcompetitions.FirstCompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial {
    private static int factorial(int num){
        int ret = 1;
        for (int i = 2; i <= num; i++) {
            ret *= i;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] info = input.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int k = (int) (Math.log(n)/Math.log(m))+1;
        System.out.println(k);
    }
}

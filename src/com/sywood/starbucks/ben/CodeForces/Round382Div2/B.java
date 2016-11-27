package com.sywood.starbucks.ben.CodeForces.Round382Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");

        int n = Integer.parseInt(data[0]);
        int n1 = Integer.parseInt(data[1]);
        int n2 = Integer.parseInt(data[2]);
        int[] people = new int[n];
        data = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(data[i]);
        }
        Arrays.sort(people);
        double mean1 = 0;
        double mean2 = 0;
        int minSize = n1 > n2 ? n2 : n1;
        int maxSize = n1 > n2 ? n1 : n2;

        int endIdx = n-minSize-1;
        for(int i = n-1; i > endIdx; i--){
            mean1 += people[i];
        }
        mean1 /= minSize;
        for(int i = endIdx; i >= 0 && i > endIdx - maxSize; i--){
            mean2 += people[i];
        }
        mean2 /= maxSize;
        double total = mean1+mean2;
        System.out.println(total);
    }
}

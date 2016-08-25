package com.sywood.starbucks.ben.CodeForces.AIMTechRound3Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-24.
 */
public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int waste = 0;
        int empty = 0;
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            int orange = Integer.parseInt(st.nextToken());
            if (orange <= b){
                waste += orange;
            }
            if (waste > d){
                empty++;
                waste = 0;
            }
        }
        System.out.println(empty);
    }
}

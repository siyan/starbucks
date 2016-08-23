package com.sywood.starbucks.ben.CodeForces.EducationalRound16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-22.
 */
public class E {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int time = x;
        int currLen = 1;
        while(currLen < n){
            if (x*(n-currLen) > y){
                time += y;
                currLen += currLen;
            }else{
                time += x;
                currLen++;
            }
        }
        System.out.println(time);
    }
}
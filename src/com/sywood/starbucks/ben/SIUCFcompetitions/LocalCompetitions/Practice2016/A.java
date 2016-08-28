package com.sywood.starbucks.ben.SIUCFcompetitions.LocalCompetitions.Practice2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-08-27.
 */
public class A {
     public static void main(String[] args)throws Exception{
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(input.readLine());
         for (int i = 0; i < N; i++) {
             int number = Integer.parseInt(input.readLine());
             System.out.println("Input value: " + number);
             if (Integer.highestOneBit(number) == number){
                 System.out.println(number);
             }else{
                 System.out.println(Integer.highestOneBit(number)<<1);
             }
             System.out.println();
         }
     }
}

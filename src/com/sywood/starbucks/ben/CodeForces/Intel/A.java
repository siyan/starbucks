package com.sywood.starbucks.ben.CodeForces.Intel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ben on 2016-10-08.
 */
public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> days = new HashMap<>();
        days.put("monday",0);
        days.put("tuesday", 1);
        days.put("wednesday", 2);
        days.put("thursday", 3);
        days.put("friday", 4);
        days.put("saturday", 5);
        days.put("sunday", 6);

        String A = input.readLine();
        String B = input.readLine();
        int diff1 = (days.get(A) + 3)%7;
        int diff2 = (days.get(A) + 2)%7;

        if(A.equals(B) || days.get(B) == diff1 || days.get(B) == diff2)
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}

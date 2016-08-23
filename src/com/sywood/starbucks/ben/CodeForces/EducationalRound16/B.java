package com.sywood.starbucks.ben.CodeForces.EducationalRound16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-22.
 */
public class B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> total = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            total.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(total);
        if (n > 1) {
            int target = n / 2;
            if (n % 2 == 0) {
                target--;
            }
            System.out.println(total.get(target));
        }else
            System.out.println(total.get(0));
    }
}

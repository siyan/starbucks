package com.sywood.starbucks.ben.CodeForces.AIMTechRound3Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Ben on 2016-08-24.
 */
public class B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        if (n == 1){
            System.out.println(0);
        }else{
            st = new StringTokenizer(input.readLine());
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(nums);
            int current = a;
            int currDist = 0;
            int best = 0;
            for (int i = 1; i < n; i++) {
                currDist += Math.abs(a-nums.get(i));
                current = nums.get(i);
            }
            best = currDist;
            current = a;
            for(int i = 0; i < n-1; i++){
                currDist += Math.abs(a-nums.get(i));
                current = nums.get(i);
            }
            best = Math.min(best, currDist);
            System.out.println(best);
        }
    }
}

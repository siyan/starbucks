package com.sywood.starbucks.ben.SIUCFcompetitions.HSPT2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ben on 2016-12-10.
 */
public class perfect {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        for(int t = 1; t <= T; t++){
            System.out.print("Wall #" + t + ": ");
            String[] data = input.readLine().split(" ");
            int w = Integer.parseInt(data[0]);
            int s = Integer.parseInt(data[1]);
            int a = Integer.parseInt(data[2]);
            int b = Integer.parseInt(data[3]);
            //if we have n windows, we have n+1 spaces. We just need to ensure that each space is the same
            int plans = 0;
            ArrayList<String> outs = new ArrayList<>();
            for(int i = a; i <= b; i++){
                int spacesTaken = s*i;
                int left = w-spacesTaken;
                int walls = i+1;
                int spaces = left/walls;
                if(spaces*walls == left && spaces > 0) {
                    plans++;
                    outs.add(i + " " + spaces);
                }
            }

            if(plans == 0) System.out.println(0);
            else{
                System.out.println(plans);
                for(String plan : outs)
                    System.out.println(plan);
            }
            System.out.println();
        }
    }
}

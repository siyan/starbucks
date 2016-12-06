package com.sywood.starbucks.ben.SIUCFcompetitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-12-03.
 */
public class nano {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        for (int i = 1; i <= n; i++) {
            String line = input.readLine();
            int pieces = 1;
            for(char c : line.toCharArray()){
                if(c == '\\' || c == '|' || c == '/' || c == '-')
                    pieces++;
            }
            System.out.print("Cyborg #" + i + ": ");
            if(pieces == 1)
                System.out.print("1 piece? You're supposed to be stronger than this!");
            else
                System.out.print(pieces + " pieces!");
            System.out.println();
        }
    }
}

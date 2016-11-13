package com.sywood.starbucks.ben.Waterloo.Waterloo2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Striker on 2016-11-11.
 */
public class ccc00s2 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int[] arr = new int[100];
        int count = n;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        int command = Integer.parseInt(input.readLine());
        int stream, percent;
        for(; command != 77; command = Integer.parseInt(input.readLine())){
            if(command == 99){
                //split
                stream = Integer.parseInt(input.readLine());
                percent = Integer.parseInt(input.readLine());
                count++;
                for(int k = count-1; k >= stream+1; k--){
                    
                }
            }
        }
    }
}

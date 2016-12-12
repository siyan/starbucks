package com.sywood.starbucks.ben.SIUCFcompetitions.HSPT2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-12-10.
 */
public class hyenas {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for(int i = 1; i <= n; i++){
            String[] data = input.readLine().split(" ");
            int r = Integer.parseInt(data[0]);
            int c = Integer.parseInt(data[1]);
            int count = 0;
            System.out.print("Location #" + i + ": ");
            for(int j = 0; j < r; j++){
                char[] arr = input.readLine().toCharArray();
                for(int k = 0; k < c; k++)
                if(arr[k] == 'H') count++;
            }
            System.out.println(count);
        }
    }
}

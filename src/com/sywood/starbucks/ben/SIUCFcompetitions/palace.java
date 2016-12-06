package com.sywood.starbucks.ben.SIUCFcompetitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-12-03.
 */
public class palace {

    public static void main(String[] arg)throws  Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 1; i <= n; i++) {
            String[] data = input.readLine().split(" ");
            int L = Integer.parseInt(data[0]);
            int x = Integer.parseInt(data[1]);
            System.out.print("Wall #" + i + ": ");
            if((L*L)/4 >= x) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

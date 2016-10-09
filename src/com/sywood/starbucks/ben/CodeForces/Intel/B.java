package com.sywood.starbucks.ben.CodeForces.Intel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Ben on 2016-10-08.
 */
public class B {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[] current = new int[m];

        boolean good = true;
        for (int i = 0; i < n; i++) {
            int wrong = 0;
            for (int j = 0; j < m; j++) {
                current[j] = input.nextInt();
            }
            for (int j = 0; j < m; j++) {
                if(current[j] != (j+1))
                    wrong++;
            }

            if(wrong-2 > (i+1)){
                System.out.println("NO");
                good = false;
                break;
            }

        }
        if(good)
            System.out.println("YES");
    }
}

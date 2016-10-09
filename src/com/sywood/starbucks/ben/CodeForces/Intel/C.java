package com.sywood.starbucks.ben.CodeForces.Intel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Ben on 2016-10-08.
 */
public class C {
    public static void main(String[] args)throws Exception{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int diff = Math.abs(n-m);
        int k = input.nextInt();

        for (int i = 0; i < k; i++) {
            int x = input.nextInt();
            int y = input.nextInt();

            if(x == y){
                System.out.println(x);
            }else if(x%2 == 1 && y%2 == 1){

            }else{
                System.out.println(-1);
            }
        }
    }
}

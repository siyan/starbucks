package com.sywood.starbucks.ben.CodeForces.Round366Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        System.out.print("I ");
        for(int i = 1; i < n; i++){
            if(i%2 == 1){
                System.out.print("hate that I ");
            }else{
                System.out.print("love that I ");
            }
        }
        if(n%2 == 1){
            System.out.print("hate it");
        }else{
            System.out.print("love it");
        }
    }
}

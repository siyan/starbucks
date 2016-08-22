package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long a = Integer.parseInt(input.readLine());
        if (a == 1 || a == 2){
            System.out.println(-1);
        }else{
            if (a%2 == 1) {
                long b = (a*a-1)/2;
                long c = b+1;
                if (a+b > c && b + c > a && a+c > b)
                    System.out.println(b + " " + c);
                else
                    System.out.println(-1);
            }else{
                long b = (a*a/4)-1;
                long c = (a*a/4)+1;
                if (a+b > c && b + c > a && a + c > b)
                    System.out.println(b + " " + c);
                else
                    System.out.println(-1);
            }
        }
    }
}

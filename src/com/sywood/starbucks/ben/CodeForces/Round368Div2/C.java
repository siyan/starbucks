package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long a = Integer.parseInt(input.readLine());
        if (a%2 == 1){
            long b = (a*a-1)/2;
            long c = b+1;
            if (a+b > c && b+c > a && a+c > b && b <= Math.pow(10, 18) && c <= Math.pow(10, 18)){
                System.out.printf("%d %d\n", b, c);
            }else{
                System.out.println(-1);
            }
        }else{
            long t = a/2;
            long b = (t*t-1)/2;
            long c = b+1;
            b *= 2;
            c *= 2;
            if (a+b > c && b+c > a && a+c > b && b <= Math.pow(10, 18) && c <= Math.pow(10, 18)){
                System.out.printf("%d %d\n", b, c);
            }else{
                System.out.println(-1);
            }
        }
    }
}

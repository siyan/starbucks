package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        String[]data = line.split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        line = input.readLine();
        data = line.split(" ");
        boolean color = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!(data[j].equals("B") || data[j].equals("W") || data[j].equals("G"))){
                    color = true;
                    break;
                }
            }
            if (color){
                break;
            }
            if (i < n-1)
                data = input.readLine().split(" ");
        }
        if(color){
            System.out.println("#Color");
        }else{
            System.out.println("#Black&White");
        }
    }
}

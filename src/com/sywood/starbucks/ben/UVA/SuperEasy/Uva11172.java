package com.sywood.starbucks.ben.UVA.SuperEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva11172 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        for (int i = 0; i < num; i++){
            String[] two = input.readLine().split(" ");
            int first = Integer.parseInt(two[0]);
            int second = Integer.parseInt(two[1]);
            if (first > second){
                System.out.println(">");
            }else if (first < second){
                System.out.println("<");
            }else{
                System.out.println("=");
            }
        }
    }
}

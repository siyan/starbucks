package com.sywood.starbucks.ben.UVA.SuperEasy;
import java.io.*;
public class UVa11044 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        for (int i = 0; i < t; i++) {
            String[] stuff = input.readLine().split(" ");
            System.out.println((Integer.parseInt(stuff[0])/3)*(Integer.parseInt(stuff[1])/3));
        }
    }
}

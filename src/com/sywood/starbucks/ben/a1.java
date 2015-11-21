package com.sywood.starbucks.ben;

import java.util.Scanner;

public class a1{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int max = Integer.parseInt(inp.nextLine());
        for (int i = 0; i < max; i++) {
            int rem = inp.nextInt();
            String remStr = inp.next();
            rem -= 1;
            remStr = remStr.substring(0, rem) + remStr.substring(rem + 1);
            System.out.println(i+1 + " " + remStr);
        }
    }
}

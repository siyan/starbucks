package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;

/**
ID: benbli
LANG: JAVA
TASK: ride
 */
public class ride {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("ride.in")));
        //PrintWriter printer = new PrintWriter(System.out);
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String A = input.readLine();
        String B = input.readLine();
        int a = 1;
        int b = 1;
        for (int i = 0; i < A.length(); i++) {
            a *= (A.charAt(i)-'A'+1);
            a %= 47;
        }
        for (int i = 0; i < B.length(); i++) {
            b *= (B.charAt(i)-'A'+1);
            b %= 47;
        }

        if (a == b){
            printer.println("GO");
        }else{
            printer.println("STAY");
        }
        printer.close();
    }
}

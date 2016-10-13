package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;

/**
ID: benbli
 LANG: JAVA
 TASK: palsquare
 */
public class palsquare {
    private static boolean isPal(String in){
        String rev = "";
        if(in.charAt(0) == '0' && in.charAt(in.length()-1) == '0') return false;
        for(int i = in.length()-1; i >= 0; i--){
            rev += in.charAt(i);
        }
        return in.equals(rev);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("palsquare.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int B = Integer.parseInt(input.readLine());

        int square ;
        for(int i = 1; i <= 300; i++){
            square = i*i;
            if(isPal(Integer.toString(square, B))){
                printer.println(Integer.toString(i, B).toUpperCase() + " " + Integer.toString(square, B).toUpperCase());
            }
        }
        printer.close();
        input.close();
    }
}

package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;

/**
 ID: benbli
 LANG: JAVA
 TASK: dualpal
 */
public class dualpal {
    private static boolean isPal(String in){
        String rev = "";
        if(in.charAt(0) == '0' && in.charAt(in.length()-1) == '0') return false;
        for(int i = in.length()-1; i >= 0; i--){
            rev += in.charAt(i);
        }
        return in.equals(rev);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//new FileInputStream("dualpal.in")));
        PrintWriter printer = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("dualpal.out")));

        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int S = Integer.parseInt(data[1])+1;

        int counter = 0;

        while(counter < N){
            int isPalCnt = 0;
            for (int i = 2; i <= 10; i++) {
                if(isPal(Integer.toString(N, i))) isPalCnt++;
            }

            if(isPalCnt >= 2){
                counter++;
                printer.println(S);
            }

            S++;
        }

        printer.close();
        input.close();

    }
}

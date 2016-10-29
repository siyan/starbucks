package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: zerosum
 */
public class zerosum {
    private static int N;
    private static int[] digits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static ArrayList<String> total = new ArrayList<String>();
    private static void recurse(int idx, int sum, int num, int sign, String curr){
       if(idx == N){
           if(sum + (sign * num) == 0)
               total.add(curr);
       }else{
           recurse(idx + 1, sum, num*10 + digits[idx], sign, curr + " " + digits[idx]);
           recurse(idx+1, sum+num*sign, digits[idx], 1, curr + "+" + digits[idx]);
           recurse(idx+1, sum+num*sign, digits[idx], -1, curr + "-" + digits[idx]);
       }

    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("zerosum.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

        N = Integer.parseInt(input.readLine());

        recurse(1, 0, 1, 1, "1");
        for(String sol : total)
            printer.println(sol);

        printer.close();
    }
}

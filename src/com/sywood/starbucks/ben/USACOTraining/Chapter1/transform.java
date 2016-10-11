//package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.Arrays;

/**
 ID: benbli
 LANG: JAVA
 TASK: transform
 */
public class transform {
    private static int N;
    private static String[] init;
    private static String[] out;

    private static String[] rotate(String[] inp){
        String[] proccess = new String[N];
        for (int i = 0; i < N; i++) {
            proccess[i] = "";
        }
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                proccess[j] += inp[i].charAt(j);
            }
        }

        return proccess;
    }

    private static String[] reflect(String[] inp){
        String[] proccess = new String[N];
        Arrays.fill(proccess, "");
        for(int row = 0; row <N; row++){
            for (int i = 0; i < N; i++) {
                proccess[row] += inp[row].charAt(N-i-1);
            }
        }
        return proccess;
    }

    private static boolean check(String[] proccess){
        boolean same = true;
        for (int i = 0; i < N; i++) {
            same &= out[i].equals(proccess[i]);
        }
        return same;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("transform.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        N = Integer.parseInt(input.readLine());
        init = new String[N];
        int value = 7;
        for (int i = 0; i < N; i++) {
            init[i] = input.readLine();
        }

        out = new String[N];
        for (int i = 0; i < N; i++) {
            out[i] = input.readLine();
        }

        boolean same = true;
        for (int i = 0; i < N; i++) {
            same &= out[i].equals(init[i]);
        }

        if(same){
           value = Math.min(value, 6);
        }
        String[] proccess = init;
        for (int i = 1; i <= 3; i++) {
            proccess = rotate(proccess);
            if(check(proccess)){
                value = Math.min(value, i);
            }else if (check(reflect(proccess))){
                value = Math.min(value, 5);
            }
        }
        proccess = rotate(proccess);
        if(check(reflect(proccess))) {
            value = Math.min(4, value);
        }else
            value = Math.min(value, 7);
        printer.println(value);
        printer.close();
        input.close();
    }
}

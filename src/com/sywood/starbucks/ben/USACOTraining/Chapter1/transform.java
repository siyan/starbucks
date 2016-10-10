package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 ID: benbli
 LANG: JAVA
 TASK: ride
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

            }
        }
    }

    private static boolean check(String[] proccess){
        boolean same = true;
        for (int i = 0; i < N; i++) {
            same = out[i].equals(proccess[i]);
        }
        return same;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        N = Integer.parseInt(input.readLine());
        init = new String[N];

        for (int i = 0; i < N; i++) {
            init[i] = input.readLine();
        }

        out = new String[N];
        for (int i = 0; i < N; i++) {
            out[i] = input.readLine();
        }

        boolean same = true;
        for (int i = 0; i < N; i++) {
            same = out[i].equals(init[i]);
        }

        if(same){
            printer.println(6);
        }else{
            String[] proccess = init;

            for (int i = 1; i <= 3; i++) {
                proccess = rotate(proccess);

                if(check(proccess)){
                    printer.println(i);
                    break;
                }
            }
        }

        printer.close();
        input.close();
    }
}

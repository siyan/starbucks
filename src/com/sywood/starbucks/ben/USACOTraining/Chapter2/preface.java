//package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;

/**
 ID: benbli
 LANG: JAVA
 TASK: preface
 */
public class preface {
    static char keys[] = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static int values[] = new int[]{1,    5,   10, 50,  100, 500, 1000};

    private static int[] vals(int N, int[] curr){
        //sleep on this, there's a problem with the code, obvious program.
        if(N == 0)
            return curr;
        else if (N == 1){
            curr[0]++;
            return curr;
        }else{
            for(int i = 6; i > 4; i--){
                if(N >= values[i]){
                    curr[i] += N/values[i];
                    N -= values[i]*(N/values[i]);
                }
                if(N >= values[i]-values[4]){
                    System.out.println("YES" + i + ", " + (i-1));
                    curr[i]++;
                    curr[4]++;
                    N -= values[i] - values[4];
                }
            }

            for(int i = 4; i > 2; i--){
                if(N >= values[i]){
                    curr[i] += N/values[i];
                    N -= values[i]*(N/values[i]);
                }
                if(N >= values[i]-values[2]){
                    curr[i]++;
                    curr[2]++;
                    N -= values[i] - values[2];
                }
            }

            for(int i = 2; i > 0; i--){
                if(N >= values[i]){
                    curr[i] += N/values[i];
                    N -= values[i]*(N/values[i]);
                }
                if(N >= values[i]-values[0]){
                    curr[i]++;
                    curr[0]++;
                    N -= values[i] - values[0];
                }
            }

            curr[0] += N;

            return curr;
        }
    }

    private static void run(int N)throws Exception{
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        int[] curr;
        int[] ret = new int[7];
        for(int i = 1; i <= N; i++){
            curr = new int[7];
            curr = vals(i, curr);
            for (int j = 0; j < 7; j++) {
                ret[j] += curr[j];
            }
        }

        for(int i = 0; i < 7; i++){
            if(ret[i] != 0)
                printer.println(keys[i] + " " + ret[i]);
        }

        printer.close();
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("preface.in")));

        int N = Integer.parseInt(input.readLine());
        input.close();
        run(N);
        //System.out.println(Arrays.toString(vals(268, new int[7])));

    }
}

package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 ID: benbli
 LANG: JAVA
 TASK: preface
 */
public class preface {
    static char keys[] = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static int values[] = new int[]{1, 5, 10, 50, 100, 500, 1000};

    private static int[] vals(int N, int[] curr){
        //sleep on this, there's a problem with the code, obvious program.
        if(N == 0)
            return curr;
        else if (N == 1){
            curr[0]++;
            return curr;
        }else{
            if(N >= 1000){
                while(N >= 1000){
                    curr[6]++;
                    N -= 1000;
                }
                if(N >= 900){
                    curr[6]++;
                    curr[5]++;
                    N -= values[6] - values[5];
                }
            }if(N >= 500){
                curr[5]++;
                N -= values[5];
                if(N >= 400){
                    curr[5]++;
                    curr[4]++;
                    N -= values[5] - values[4];
                }
            }if(N >= 100){
                while(N >= 100){
                    curr[3]++;
                    N -= values[3];
                }
                if(N >= 90){
                    curr[3]++;
                    curr[2]++;
                    N -= values[3] - values[2];
                }
            }
            return vals(N, curr);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        int N = Integer.parseInt(input.readLine());
        input.close();
        //run(N);

        printer.close();
    }
}

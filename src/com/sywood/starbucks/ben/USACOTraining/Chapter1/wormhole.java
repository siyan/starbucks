package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.Arrays;

/**
 ID: benbli
 LANG: JAVA
 TASK: wormhole
 */
public class wormhole {
    private static int N;
    private static int[] X = new int[13], Y = new int[13], partners = new int[13], nextOnRight = new int[13];

    private static int solve(){
        int i = 1, total = 0;
        for(; i <= N; i++)
            if(partners[i] == 0)
                break;

        if(i > N){
            if(cycleExists()) return 1;
            return 0;
        }
        for(int j = i+1; j <= N; j++){
            if(partners[j] == 0) {
                partners[i] = j;
                partners[j] = i;
                total += solve();
                partners[i] = partners[j] = 0;
            }
        }
        return total;
    }

    private static boolean cycleExists(){
        for(int start = 1; start <= N; start++){
            int pos = start;
            for(int count = 0; count < N; count++)
                pos = nextOnRight[partners[pos]];
            if(pos != 0)
                return true;
        }
        return false;
    }



    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("wormhole.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

        N = Integer.parseInt(input.readLine());
        String[] data;
        for (int i = 1; i <= N; i++) {
            data = input.readLine().split(" ");
            X[i] = Integer.parseInt(data[0]);
            Y[i] = Integer.parseInt(data[1]);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(X[j] > X[i] && Y[i] == Y[j]){
                    if(nextOnRight[i] == 0 || X[j]-X[i] < X[nextOnRight[i]] - X[i])
                        nextOnRight[i] = j;
                }
            }
        }


        printer.println(solve());
        printer.close();
        input.close();
    }
}

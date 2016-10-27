package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 ID: benbli
 LANG: JAVA
 TASK: lamps
 */
public class lamps {
    private static String toStr(boolean[] inp){
        String ret = "";
        for(boolean t : inp)
            ret += t ? 0 : 1;
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("lamps.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        int N = Integer.parseInt(input.readLine());
        int C = Integer.parseInt(input.readLine());
        int[] possible = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());

        int t;
        while((t = Integer.parseInt(st.nextToken())) != -1){
            possible[t-1] = 2;
        }

        st = new StringTokenizer(input.readLine());

        while((t = Integer.parseInt(st.nextToken())) != -1){
            possible[t-1] = 1;
        }

        //loop through all 2^4 possible combinations, check if there are C or less number of buttons
        boolean[] process;
        boolean made = false;
        TreeSet<String> solutions = new TreeSet<String>();
        outer:
        for (int i = 0; i < 1 << 4; i++) {
            if(Integer.bitCount(i) <= C){
                process = new boolean[N];
                if((i&1) > 0){
                    for (int j = 0; j < N; j++) {
                        process[j] = !process[j];
                    }
                }if((i&(1<<1)) > 0){
                    for(int j = 0; j < N; j += 2){
                        process[j] = !process[j];
                    }
                }if((i&(1<<2)) > 0){
                    for(int j = 1; j < N; j+= 2){
                        process[j] = !process[j];
                    }
                }if((i&(1<<3)) > 0){
                    process[0] = !process[0];
                    for(int j = 3; j < N; j += 3)
                        process[j] = !process[j];
                }
                for (int j = 0; j < N; j++) {
                    if(possible[j] != 0){
                        if(possible[j] == 2 && process[j]) continue outer;
                        else if (possible[j] == 1 && !process[j]) continue outer;
                    }
                }
                solutions.add(toStr(process));
            }
        }
        if(solutions.isEmpty())
            printer.println("IMPOSSIBLE");
        else
            for(String sol : solutions)
                printer.println(sol);
        printer.close();
    }
}

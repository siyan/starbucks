//package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 ID: benbli
 LANG: JAVA
 TASK: ariprog
 */

public class ariprog {
    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("ariprog.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        input.close();
        boolean isBisquare[] = new boolean[M * M * 2+1];
        for (int a = 0; a <= M; a++){ //find all bisquares
            for (int b = a; b <= M; b++) {
                int bisquare = a * a + b * b;
                isBisquare[bisquare] = true;
            }
        }

        ArrayList<int[]> combos = new ArrayList<int[]>();
        for(int a = 0; a < M*M*2; a++){
            if(!isBisquare[a]) continue; //if a isn't a bisquare, don't bother
            label:
            for(int b = 1; b <= (M*M*2-a)/(N-1); b++){ //find the value of b using the formula
                for(int i = 1; i <= (N-1); i++){ //check each value of the progression
                    if(!isBisquare[a + b*i])
                        continue label;
                }
                combos.add(new int[]{a, b}); //is a valid progression
            }
        }

        Collections.sort(combos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) return -1;
                if(o1[1] > o2[1]) return 1;
                if(o1[0] < o2[0]) return -1;
                if(o1[0] > o2[0]) return 1;
                return 0;
            }
        });

        if(combos.size() == 0)
            printer.println("NONE");
        else{
            for(int[] combo : combos){
                printer.println(combo[0] + " " + combo[1]);
            }
        }

        printer.close();
    }
}

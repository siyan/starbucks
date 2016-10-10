package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;

/**
 ID: benbli
 LANG: JAVA
 TASK: beads
 */
public class beads {
    public static void main(String args[])throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("beads.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int N = Integer.parseInt(input.readLine());
        String seq = input.readLine();
        String process;

        int best = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            process = seq.substring(i, N) + seq.substring(0, i);
            int l = 0;
            char col = 'w';
            for (int j = 0; j < N; j++) {
                if(process.charAt(j) == 'w')
                    l++;
                else{
                    if(col == 'w'){
                        col = process.charAt(j);
                        l++;
                    }else{
                        if(col != process.charAt(j)) {
                            break;
                        }else
                            l++;
                    }
                }
                idx = j;
            }
            int r = 0;
            boolean colSwitch = false;
            int rCol = 'w';

            for(int j = N-1; j > idx; j--){
                if(!colSwitch){
                    if (col != process.charAt(j) && process.charAt(j) != 'w') {
                        colSwitch = true;
                        rCol = process.charAt(j);
                    }
                }else{
                    if (rCol != process.charAt(j) && process.charAt(j) != 'w') {
                        break;
                    }
                }
                r++;
            }
            best = Math.max(best, r+l);
        }

        printer.println(best);
        printer.close();
    }
}

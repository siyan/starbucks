package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.Arrays;

/**
 ID: benbli
 LANG: JAVA
 TASK: skidesign
 */
public class skidesign {
    private static int[] hills;
    private static int solve(){
        int total = Integer.MAX_VALUE;

        for(int i = 0; i <= 100; i++){
            int cost = 0;
            int maxH = i + 17;
            for(int hill : hills){
                if(hill < i){
                    cost += (i-hill)*(i-hill);
                } else if (hill > maxH)
                    cost += (hill-maxH)*(hill-maxH);
            }
            total = Math.min(total, cost);
        }

        return total;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("skidesign.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int N = Integer.parseInt(input.readLine());
        hills = new int[N];
        for (int i = 0; i < N; i++) {
            hills[i] = Integer.parseInt(input.readLine());
        }
        input.close();
        Arrays.sort(hills);
        int diff = hills[N-1] - hills[0];

        if(diff <= 17)
            printer.println(0);
        else
            printer.println(solve());
        printer.close();
    }
}

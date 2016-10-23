package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;

/**
 ID: benbli
 LANG: JAVA
 TASK: subset
 */
public class subset {

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("subset.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        int N = Integer.parseInt(input.readLine());
        int sum = N*(N+1)/2;

        if(sum % 2 == 1)
            printer.println(0);
        else{
            int maxR = N;
            int maxNum = sum/2;

            long [][] memo = new long[maxR+1][maxNum+1];
            for(int i = 0; i <= N; i++) memo[i][0] = 1; //can take 0 numbers in 1 way

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= maxNum; j++){
                    memo[i][j] += memo[i-1][j];
                    if(i <= j) memo[i][j] += memo[i-1][j-i];
                }
            }
            printer.println(memo[N][maxNum]/2);
        }
        printer.close();
    }
}

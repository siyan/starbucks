//package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.StringTokenizer;

/**
ID: benbli
 LANG: JAVA
 TASK: crypt1
 */

public class crypt1 {

    private static boolean possible[];

    private static boolean check(int num){
        for(; num > 0; num /= 10){
            if(!possible[num%10])return false;
        }
        return true;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("crypt1.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        int N  = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine());

        int[] digits = new int[N];
        possible = new boolean[10];

        for (int i = 0; i < N; i++) {
            digits[i] = Integer.parseInt(st.nextToken());
            possible[digits[i]] = true;
        }
        int count = 0;
        for(int A : digits)
            for(int B : digits)
                for(int C : digits)
                    for(int D : digits)
                        for(int E : digits){
                            int abc = 100*A + 10*B + C;
                            int de = D*10 + E;

                            if(Integer.toString(abc*E).length() == 3 &&
                                    Integer.toString(abc*D).length() == 3 && Integer.toString(abc*de).length() == 4 &&
                                    check(abc) && check(de) && check(abc*de) && check(abc*E) && check(abc*D))
                                count++;
                        }
        printer.println(count);
        printer.close();
        input.close();
    }
}

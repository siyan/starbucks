package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 ID: benbli
 LANG: JAVA
 TASK: milk3
 */
public class milk3 {
    private class state{
        int A, B, C;
        public state(int A, int B, int C){
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    private static TreeSet<Integer> values = new TreeSet<>();
    private static int A, B, C;
    private static void solve(int A, int B, int C){
        if(!values.contains(C)){

        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        StringTokenizer st =  new StringTokenizer(input.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input.close();

        //found A, B, C
        //recursively iterate through all pours possible?

        solve(0, 0, C);

        printer.close();
    }
}

package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 ID: benbli
 LANG: JAVA
 TASK: milk3
 */
public class milk3 {
    public static boolean[][][] visited;

    private static TreeSet<Integer> values = new TreeSet<Integer>();
    private static int A, B, C;

    private static int[] pour(int init, int end, int idxS, int idxE){
        int[] ret = new int[2]; //{start, end}
        if(idxS == 0){
            if(idxE == 1){//A to B
                if(B - end >= init){
                    ret[0] = 0;
                    ret[1] = end + init;
                }else{
                    ret[0] = init - (B-end);
                    ret[1] = end + (B-end);
                }
                return ret;
            }else{//A to C
                if(C - end >= init){
                    ret[0] = 0;
                    ret[1] = end + init;
                }else{
                    ret[0] = init - (C-end);
                    ret[1] = end + (C-end);
                }
                return ret;
            }
        }else if (idxS == 1){
            if(idxE == 2){//B to C
                if(C - end >= init){
                    ret[0] = 0;
                    ret[1] = end + init;
                }else{
                    ret[0] = init - (C-end);
                    ret[1] = end + (C-end);
                }
                return ret;
            }else{//B to A
                if(A - end >= init){
                    ret[0] = 0;
                    ret[1] = end + init;
                }else{
                    ret[0] = init - (A-end);
                    ret[1] = end + (A-end);
                }
                return ret;
            }
        }else{
            if(idxE == 1){//C to B
                if(B - end >= init){
                    ret[0] = 0;
                    ret[1] = end + init;
                }else{
                    ret[0] = init - (B-end);
                    ret[1] = end + (B-end);
                }
                return ret;
            }else{
                if(A - end >= init){
                    ret[0] = 0;
                    ret[1] = end + init;
                }else{
                    ret[0] = init - (A-end);
                    ret[1] = end + (A-end);
                }
                return ret;
            }
        }
    }

    private static void solve(int A, int B, int C){
        if(!visited[A][B][C]){

            visited[A][B][C] = true;
            if(A == 0)
                values.add(C);
            int[] t = pour(C, A, 2, 0);
            solve(t[1], B, t[0]);
            t = pour(C, B, 2, 1);
            solve(A, t[1], t[0]);
            t = pour(A, C, 0, 2);
            solve(t[0], B, t[1]);
            t = pour(A, B, 0, 1);
            solve(t[0], t[1], C);
            t = pour(B, C, 1, 2);
            solve(A, t[0], t[1]);
            t = pour(B, A, 1, 0);
            solve(t[1], t[0], C);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("milk3.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        StringTokenizer st =  new StringTokenizer(input.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input.close();

        visited = new boolean[A+1][B+1][C+1];

        solve(0, 0, C);
        String ret = "";
        for(int c : values)
            ret += c + " ";
        printer.println(ret.trim());

        printer.close();
    }
}

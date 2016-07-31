package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Third underlined basic Data Structures question
 * SUFFERING
 */
public class UVa12356 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line;
        int[] LS = new int[100005];
        int[] RS = new int[100005];
        while ((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (S == 0 && B == 0){
                break;
            }
            for (int i = 1; i <= S; i++) {
                LS[i] = i-1;
                RS[i] = i+1;
            }
            for (int i = 0; i < B; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                if (LS[L] == 0 || LS[R] < 1) {
                    printer.print("* ");
                } else {
                    printer.print(LS[L] + " ");
                }
                if(RS[R] == 0 || RS[R] > S) {
                    printer.print("*\n");
                } else {
                    printer.print(RS[R]+"\n");
                }
                LS[RS[R]] = LS[L];
                RS[LS[L]] = RS[R];
            }
            printer.print("-\n");
        }
        br.close();
        printer.close();
    }
}

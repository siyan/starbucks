package com.sywood.starbucks.ben.CodeForces.Round366Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()), type, temp, unread = 0;
        ArrayDeque<Integer> notifications = new ArrayDeque<>();
        ArrayDeque<Integer>[] apps = new ArrayDeque[n];
        boolean[] mark = new boolean[q];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(input.readLine());
            type = Integer.parseInt(st.nextToken());
            if(type == 1){
                temp = Integer.parseInt(st.nextToken());
                unread++;
                notifications.addLast(temp);
            }else if (type == 2){

            }
        }

        printer.close();
    }
}

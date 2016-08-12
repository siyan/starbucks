package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * third sorted greedy problem
 */
public class UVa12210 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line = input.readLine();
        int b, s, counter = 1;
        Integer[] bachelors;
        while(!line.equals("0 0")){
            st = new StringTokenizer(line);
            b = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            bachelors = new Integer[b];
            for (int i = 0; i < b; i++) {
                bachelors[i] = Integer.parseInt(input.readLine());
            }
            Arrays.sort(bachelors);
            for (int i = 0; i < s; i++) {
                input.readLine();
            }
            if (b > s){
                printer.printf("Case %d: %d %d\n",counter,  (b-s), bachelors[0]);
            }else {
                printer.printf("Case %d: 0", counter);
            }
            line = input.readLine();
            counter++;
        }
    }
}

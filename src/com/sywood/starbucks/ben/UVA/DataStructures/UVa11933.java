package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * third underlined bitset question
 */
public class UVa11933 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line = input.readLine();
        while(!line.equals("0")){
            st = new StringTokenizer(line);
            long test = Long.parseLong(st.nextToken());
            long a = 0;
            long b = 0;
            int counter = 0;
            for (int i = 0; i <= Long.toBinaryString(test).length(); i++) {
                if ((test & (1<<i)) > 0){
                    if ((counter++&1) == 0){
                        a += 1<<i;
                    }else{
                        b += 1<<i;
                    }
                }
            }
            printer.println(a + " " + b);
            line = input.readLine();
        }
        printer.close();
    }
}

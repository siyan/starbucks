package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * First stack question.
 */
public class UVa514 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        Stack<Integer> in, middle, out;
        String line = input.readLine();
        int n, counter;
        int[] items;
        boolean possible = true;

        while(!line.equals("0")){
            n = Integer.parseInt(line);
            in = new Stack<>();
            middle = new Stack<>();
            out = new Stack<>();
            for(int i = n; i >= 1; i--){
                in.push(i);
            }
            line = input.readLine();
            while(!line.equals("0")){
                st = new StringTokenizer(line);
                items = new int[n];
                for (int i = 0; i < n; i++) {
                    items[i] = Integer.parseInt(st.nextToken());
                }
                for (int i = 0; i < n; i++) {
                    if(in.contains(items[i])){
                        while(in.peek() != items[i]){
                            middle.push(in.pop());
                        }
                        out.push(in.pop());
                    }else if (!middle.isEmpty() && middle.peek() == items[i]) {
                        out.push(middle.pop());
                    } else{
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    printer.println("Yes");
                }else{
                    printer.println("No");
                }
                possible = true;
                out.clear();
                middle.clear();
                in.clear();
                for (int i = n; i >= 1; i--) {
                    in.push(i);
                }
                line = input.readLine();
            }
            line = input.readLine();
            printer.println();
        }


        printer.close();
    }
}

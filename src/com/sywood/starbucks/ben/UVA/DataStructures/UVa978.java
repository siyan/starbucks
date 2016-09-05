package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * First treeSet problem
 */
public class UVa978 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st;
        for (int t = 1; t <= N; t++) {
            st = new StringTokenizer(input.readLine());
            int B = Integer.parseInt(st.nextToken());
            int nG = Integer.parseInt(st.nextToken());
            int nB = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> green = new PriorityQueue<>(Collections.<Integer>reverseOrder());
            PriorityQueue<Integer> blue = new PriorityQueue<>(Collections.<Integer>reverseOrder());

            for (int j = 0; j < nG; j++)
                green.add(Integer.parseInt(input.readLine()));

            for(int j = 0; j < nB; j++)
                blue.add(Integer.parseInt(input.readLine()));

            while(!green.isEmpty() && !blue.isEmpty()){
                int battles = Math.min(B, Math.min(green.size(), blue.size()));
                ArrayList<Integer> greenWin = new ArrayList<>();
                ArrayList<Integer> blueWin = new ArrayList<>();

                for (int i = 0; i < battles; i++) {
                    if (green.peek() > blue.peek())
                        greenWin.add(green.peek()-blue.peek());
                    else if (blue.peek() > green.peek())
                        blueWin.add(blue.peek()-green.peek());
                    green.poll();
                    blue.poll();
                }
                for(int value : greenWin)
                    green.add(value);
                for(int value : blueWin)
                    blue.add(value);
            }

            if(green.isEmpty() && blue.isEmpty())
                printer.println("green and blue died");
            else if (!green.isEmpty()) {
                printer.println("green wins");
                while(!green.isEmpty())
                    printer.println(green.poll());
            }else {
                printer.println("blue wins");
                while(!blue.isEmpty())
                    printer.println(blue.poll());
            }
            if (t < N)
                printer.println();
        }
        printer.close();
    }
}

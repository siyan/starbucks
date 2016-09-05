package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
            int[][] fields = new int[B][];
            int nG = Integer.parseInt(st.nextToken());
            int nB = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> green = new PriorityQueue<>(Collections.<Integer>reverseOrder());
            PriorityQueue<Integer> blue = new PriorityQueue<>(Collections.<Integer>reverseOrder());

            for (int j = 0; j < nG; j++)
                green.add(Integer.parseInt(input.readLine()));

            for(int j = 0; j < nB; j++)
                blue.add(Integer.parseInt(input.readLine()));

            while(!green.isEmpty() && !blue.isEmpty()){
                for(int i = 0; i < B && !green.isEmpty() && !blue.isEmpty(); i++){
                    int diff = green.poll() - blue.poll();
                    if (diff != 0){
                        if (diff > 0)
                            fields[i] = new int[]{1, -diff};
                        else
                            fields[i] = new int[]{2, diff};
                    }
                }
                for(int i = 0; i < B; i++){
                    if (fields[i] != null){
                        if (fields[i][0] == 1)
                            green.add(fields[i][1]);
                        else
                            blue.add(fields[i][1]);
                    }
                }
            }

            if(green.isEmpty() && blue.isEmpty())
                printer.println("green and blue died");
            else if (!green.isEmpty()) {
                printer.println("green wins");
                while(!green.isEmpty())
                    printer.println(-green.poll());
            }else {
                printer.println("blue wins");
                while(!blue.isEmpty())
                    printer.println(-blue.poll());
            }
            if (t < N)
                printer.println();
        }
        printer.close();
    }
}

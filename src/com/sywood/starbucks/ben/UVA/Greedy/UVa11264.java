package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * First underlined greedy problem.
 */
public class UVa11264 {
    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        int T = Integer.parseInt(input.readLine()), size, counter;
        long sum;
        for (int i = 0; i < T; i++) {
            counter = 1;
            size = Integer.parseInt(input.readLine());
            int[] coins = new int[size];
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < size; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            sum = coins[0];
            for(int j = 1; j < size-1; j++){
                if (coins[j] + sum < coins[j+1]){
                    sum += coins[j];
                    counter++;
                }
            }
            printer.println(counter+1);
        }
        printer.close();
    }
}

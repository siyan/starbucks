package com.sywood.starbucks.ben.UVA.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVa507 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        int b = Integer.parseInt(input.readLine());
        for(int i = 1; i <= b; i++){
            int start = 0;
            int sum = 0;
            int best = 0;
            int bestStart = 1;
            int bestEnd = 1;
            int size = Integer.parseInt(input.readLine().trim());
            int[] values = new int[size-1];
            for (int j = 0; j < size - 1; j++) {
                values[j] = Integer.parseInt(input.readLine().trim());
            }

            for(int j = 1; j < size; j++){
                sum += values[j-1];
                if (sum > best || (sum == best && j-start > bestEnd - bestStart)){
                    best = sum;
                    bestEnd = j;
                    bestStart = start;
                }
                if (sum < 0){
                    start = j;
                    sum = 0;
                }
            }
            if (bestStart != bestEnd)
                printer.printf("The nicest part of route %d is between stops %d and %d\n", i, bestStart+1, bestEnd+1);
            else
                printer.printf("Route %d has no nice parts\n", i);
        }
        printer.close();
    }
}

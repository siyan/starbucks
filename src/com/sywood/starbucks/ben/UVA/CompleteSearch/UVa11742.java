package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
public class UVa11742 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] stuff = input.readLine().split(" ");
        int n = Integer.parseInt(stuff[0]);
        int m = Integer.parseInt(stuff[1]);
        int[] seats = new int[n];
        for (int i = 1; i <= n; i++){
            seats[i-1] = i;
        }
        for (int i = 0; i < m; i++) {
            int[] temp = seats;
            int counter = 0;

        }
    }
}
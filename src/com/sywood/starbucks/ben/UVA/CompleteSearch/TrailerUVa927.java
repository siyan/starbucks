package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class TrailerUVa927 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(input.readLine());
        for (int i = 0; i < C; i++) {
            String[] c = input.readLine().split(" ");
            int d = Integer.parseInt(input.readLine());
            int k = Integer.parseInt(input.readLine());
            int degree = (int) Math.floor((1+Math.sqrt(2*k))/2);
            int a = 0;
            for (int j = 0; j <= degree; j++) {
                a += Integer.parseInt(c[j]);
            }
        }
    }
}

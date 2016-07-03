package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class UVa1260 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(input.readLine());
            int[] data = new int[n];
            String[] stuff = input.readLine().split(" ");
            for (int j = 0; j < stuff.length; j++) {
                data[j] = Integer.parseInt(stuff[j]);
            }
            int counter = 0;
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < j; k++) {
                    if (data[j] >= data[k]){
                        //System.out.println(data[j] + ">= " + data[k]);
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
    }
}

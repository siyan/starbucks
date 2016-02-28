package com.sywood.starbucks.ben;
import java.io.*;

public class ReadToScan {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(input.readLine());
        for (int i = 0; i < iter; i++) {
            System.out.println(input.readLine());
        }
    }
}

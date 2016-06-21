package com.sywood.starbucks.ben.UVA.SuperEasy;
import java.io.*;

public class UVa01124 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (line != null && !line.equals("\n") && !line.equals("")){
            System.out.println(line);
            line = input.readLine();
        }
    }
}

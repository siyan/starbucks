package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;
import java.io.*;

public class unhappy {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0 0")){
            String[] data = line.split(" ");
            int lo = Integer.parseInt(data[0]);
            int hi = Integer.parseInt(data[1]);
            for (int i = lo; i < hi; i++) {
                String currentDigits = "";
                int temp = i;
                while (temp != 1){

                }
            }
        }
    }
}

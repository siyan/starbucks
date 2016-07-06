package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;
import java.io.*;

public class shuffle {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0")) {
            int n = Integer.parseInt(line);
            String[] cards = new String[n];
            for (int i = 0; i < n; i++) {
                cards[i] = input.readLine();
            }
            int middle = n/2 + n%2;
            for (int i = 0; i < middle && middle+i < n; i++) {
                System.out.println(cards[i]);
                System.out.println(cards[middle+i]);
            }
            if (n%2 == 1){
                System.out.println(cards[middle-1]);
            }
            line = input.readLine();
        }

    }
}

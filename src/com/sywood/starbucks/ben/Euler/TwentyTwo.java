package com.sywood.starbucks.ben.Euler;
import java.io.*;
public class TwentyTwo {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Striker\\IdeaProjects\\Starbucks\\data\\names.in"));
        String[] names = input.readLine().split(" ");
        long sum = 0;
        for(int i = 1; i <= names.length; i++){
            long tot = 0;
            for (char letter : names[i-1].toCharArray()){
                tot += (long) letter;
                tot -= 64;
            }
            tot = tot*(i);
            sum += tot;
        }
    }
}

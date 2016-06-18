package com.sywood.starbucks.ben.Euler.Twenties;
import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class TwentyTwo {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Striker\\IdeaProjects\\Starbucks\\data\\names.in"));
        String[] names = input.readLine().split(" ");
        Collections.sort(Arrays.asList(names));
        BigInteger sum = BigInteger.ZERO;
        for(int i = 1; i <= names.length; i++){
            BigInteger tot = BigInteger.ZERO;
            for (char letter : names[i-1].toCharArray()){
                tot = tot.add(BigInteger.valueOf((long)letter - 64));
            }
            tot = tot.multiply(BigInteger.valueOf(i));
            sum = sum.add(tot);
        }
        System.out.println(sum);
    }
}

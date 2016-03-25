package com.sywood.starbucks.ben.Euler;
import java.math.BigInteger;
import java.io.*;

public class Thirteen {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Striker\\IdeaProjects\\Starbucks\\data\\thirteen.in"));
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < 100; i++) {
            BigInteger temp = new BigInteger(input.readLine());
            sum = sum.add(temp);
        }
        String ret = sum.toString();
        System.out.println(ret.substring(0, 10));
    }
}

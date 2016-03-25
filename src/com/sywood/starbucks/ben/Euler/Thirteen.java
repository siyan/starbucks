package com.sywood.starbucks.ben.Euler;
import java.math.BigInteger;
import java.io.*;

public class Thirteen {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Striker\\IdeaProjects\\Starbucks\\data\\thirteen.in"));
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < 50; i++) {
            BigInteger temp = new BigInteger(input.readLine());
            sum = sum.add(temp);
        }
        BigInteger digit = BigInteger.ZERO;
        while(sum.compareTo(BigInteger.TEN) != -1){
            digit = digit.add(sum.mod(BigInteger.TEN));
            sum = sum.divide(BigInteger.TEN);
        }
        digit = digit.add(sum.mod(BigInteger.TEN));
        System.out.println(digit);
    }
}

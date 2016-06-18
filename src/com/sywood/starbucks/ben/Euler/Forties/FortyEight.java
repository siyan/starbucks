package com.sywood.starbucks.ben.Euler.Forties;

import java.math.BigInteger;

public class FortyEight {
    public static void main(String[] args){
        BigInteger sum = BigInteger.valueOf(10405071317L);
        for (int i = 11; i <= 1000; i++) {
            BigInteger temp = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i));
            sum = sum.add(temp);
        }
        System.out.println(sum);
    }
}

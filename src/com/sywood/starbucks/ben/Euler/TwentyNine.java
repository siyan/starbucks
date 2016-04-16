package com.sywood.starbucks.ben.Euler;
import java.util.Set;
import java.util.HashSet;

public class TwentyNine {
    public static void main(String[] args){
        Set<Double> distinct = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++){
                distinct.add(Math.pow(a, b));
            }
        }
        System.out.println(distinct.size());
    }
}

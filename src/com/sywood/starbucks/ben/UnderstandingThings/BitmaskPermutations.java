package com.sywood.starbucks.ben.UnderstandingThings;

public class BitmaskPermutations {
    public static void main(String[] args){
        int max = 4; // number of items.
        for (int i = 1<<(max-1); i < 1<<max; i++) {
            System.out.printf("%5s\n", Integer.toBinaryString(i));
        }
    }
}

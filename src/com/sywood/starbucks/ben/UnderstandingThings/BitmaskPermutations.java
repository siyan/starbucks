package com.sywood.starbucks.ben.UnderstandingThings;

public class BitmaskPermutations {
    public static void main(String[] args){
        /*
        int max = 10; // number of items.
        for (int i = 0; i < 1<<max; i++) {
            System.out.printf("%5s\n", Integer.toBinaryString(i));
        }*/
        int i = (1<<2)-1;
        System.out.println(i);
        for (int j = 0; j < 2; j++) {
            System.out.println(Integer.toBinaryString(i>>j%2) + " " + ((i>>j)%2 == 1));
        }
    }
}

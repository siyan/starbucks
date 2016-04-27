package com.sywood.starbucks.siyan.ccc;

import java.util.Arrays;

/**
 * Created by siyan on 2016-04-26.
 */
public class UVa12455 {

    static int[] l = {1, 3, 5, 8, 14};
    static int X = 12;

    static boolean[] mask(int num ) {
        boolean[] b = new boolean[l.length];
        char[] c = Integer.toBinaryString( num ).toCharArray();
        for( int i = 0; i < c.length; i++ ) {
            b[i] = c[i] == '1';
        }
        for( int i = c.length; i < b.length; i++ ) {
            b[i] = false;
        }
        return b;
    }

    public static void main(String[] args ) {

        int N = (int)Math.pow(2, l.length);

        for (int i = 1; i < N; i++) { // for each subset, O(2^n)
            int sum = 0;
            boolean[] mask = mask(i);

            for (int j = 0; j < l.length; j++) { // check membership, O(n)
                if (mask[j]) // test if bit ‘j’ is turned on in subset ‘i’?
                    sum += l[j]; // if yes, process ‘j’
            }

            if (sum == X) {
                System.out.println( "Fund: " + Arrays.toString(mask) + ", " + Arrays.toString(l) + " = " + X );
                break; // the answer is found: bitmask ‘i’
            }
        }
    }
}

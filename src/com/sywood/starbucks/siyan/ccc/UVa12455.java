package com.sywood.starbucks.siyan.ccc;

import java.util.Arrays;

/**
 * Created by siyan on 2016-04-26.
 */
public class UVa12455 {

    static int[] l = {1, 3, 5, 8, 14};
    static int X = 22;

    static void useBitOp() {
        for (int i = 0; i < (1 << l.length); i++) { // for each subset, O(2^n)
            int sum = 0;
            for (int j = 0; j < l.length; j++) // check membership, O(n)
                if ((i & (1 << j)) > 0) // test if bit ‘j’ is turned on in subset ‘i’?
                    sum += l[j]; // if yes, process ‘j’

            if (sum == X) {
                System.out.println("Fund: " + Integer.toBinaryString(i) + ", " + Arrays.toString(l) + " = " + X);
                break; // the answer is found: bitmask ‘i’
            }
        }
    }

    static void useArray( ) {

        int N = (int)Math.pow(2, l.length);

        for (int i = 1; i < N; i++) { // for each subset, O(2^n)
            int sum = 0;
            boolean[] mask = new boolean[l.length];
            char[] c = Integer.toBinaryString( i ).toCharArray();
            for( int k = 0; k < c.length; k++ ) {
                mask[c.length-k-1] = c[k] == '1';
            }

            for (int j = 0; j < l.length; j++) { // check membership, O(n)
                if (mask[j]) // test if bit ‘j’ is turned on in subset ‘i’?
                    sum += l[j]; // if yes, process ‘j’
            }

            if (sum == X) {
                System.out.println( "Fund: " + Arrays.toString(mask) + ", " + Arrays.toString(l) + " = " + X );
                break; // the answer is found: mask
            }
        }
    }

    public static void main(String[] args ) {
        useArray();
        useBitOp();
    }

}

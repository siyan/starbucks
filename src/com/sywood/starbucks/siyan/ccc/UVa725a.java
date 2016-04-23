package com.sywood.starbucks.siyan.ccc;

/**
 * Created by siyan on 2016-04-23.
 */
public class UVa725a {

    public static void bitOperation() {
        int a = 13;
        int b = 60;


        System.out.println( a + " => " + Integer.toBinaryString( a ));
        System.out.println( b + " => " + Integer.toBinaryString( b ));

        System.out.println( "\n***** bitwise logic:\n");

        int c = a & b;
        System.out.println( "a and b  => " + c + ", " + Integer.toBinaryString ( c ));
        c = a | b;
        System.out.println( "a or b   => " + c + ", " + Integer.toBinaryString ( c ));
        c = a ^ b;
        System.out.println( "a xor b  => " + c + ", " + Integer.toBinaryString ( c ));

        System.out.println( "\n***** bit shift:\n");
        System.out.println( a + " = " + Integer.toBinaryString( a ));
        System.out.println( a + " left shift 1 => "  + ( a << 1 ) + ", " + Integer.toBinaryString( a << 1 ));
        System.out.println( a + " left shift 2 => "  + ( a << 2 ) + ", " + Integer.toBinaryString( a << 2 ));
        System.out.println( a + " right shift 1 => " + ( a >> 1 ) + ", " + Integer.toBinaryString( a >> 1 ));
        System.out.println( a + " right shift 2 => " + ( a >> 2 ) + ", " + Integer.toBinaryString( a >> 2 ));
    }

    public static void solution() {

        int N = 3;
        for (int fghij = 1234; fghij <= 98765 / N; fghij++) {
            int abcde = fghij * N; // this way, abcde and fghij are at most 5 digits
            int tmp;
            int used = (fghij < 10000) ? 1 : 0; // if digit f=0, then we have to flag it
            tmp = abcde;

            while (tmp > 0) {
                used |= 1 << (tmp % 10);
                tmp /= 10;
            }

            tmp = fghij;

            while (tmp > 0) {
                used |= 1 << (tmp % 10);
                tmp /= 10;
            }

            if (used == (1<<10) - 1) {// if all digits are used, print it
                System.out.println(abcde + " / " + fghij + " = " + N);
            }
        }

    }

    public static void main(String[] args) {
        bitOperation();
        solution();
    }
}

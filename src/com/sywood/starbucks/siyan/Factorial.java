package com.sywood.starbucks.siyan;

/**
 * Created by siyan on 8/19/15.
 */
public class Factorial {
    public static int factorial( int n ) {
        if( n == 0 )
            return 1;
        else
            return n * factorial( n - 1 );
    }

    public static void main( String[] args ) {
        int n = 6;
        int f = factorial( n );

        System.out.println( n + ": " + f);
    }
}

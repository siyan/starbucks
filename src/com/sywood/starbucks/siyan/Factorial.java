package com.sywood.starbucks.siyan;

import java.util.Date;

/**
 * Created by siyan on 8/19/15.
 */
public class Factorial {
    static int c;
    public static long factorial( int n ) {
        if( n == 0 )
            return 1;
        else {
            c++;
            return n * factorial(n - 1);
        }
    }

    public static long fabLoop( int n ) {
        for( int i = 0; i <= n; i++ ) {
            if( i == 0 || i == 1 ) val[i] = 1;
            else {
                val[i] = val[i-1] + val[i-2];
            }
        }
        return val[n];
    }

    public static long fabDP( int n ) {
        if( n == 0 || n == 1 ) {
            return val[n] = 1;
        }
        else {
            if( val[n] == 0) {
                val[n] = fabDP(n-1) + fabDP(n-2);
            }
            return val[n];
        }
    }

    public static long fabRecu( int n ) {
        if( n == 0 || n == 1 ) {
            return 1;
        }
        else {
            System.out.println( "fab: " + n );
            return fabRecu( n - 1 ) + fabRecu( n - 2);
        }
    }

    static long[] val;
    public static void main( String[] args ) {
        int n = 20;
        val = new long[n];

        System.out.println( new Date());

        //long f = factorial(n);

        long f = fabLoop(n - 1);

        System.out.println( n + ": " + f);
        System.out.println( new Date());
    }
}

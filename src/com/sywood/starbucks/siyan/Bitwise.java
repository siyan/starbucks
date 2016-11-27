package com.sywood.starbucks.siyan;

/**
 * Created by siyan on 2016-11-10.
 */
public class Bitwise {

    public static int eq( int a, int b ) {
        return ~a & b ;
    }

    public static void main( String[] args ) {
        int a =  eq( 2, 7);
        System.out.println( a );
    }

}

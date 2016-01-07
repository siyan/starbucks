package com.sywood.starbucks.siyan.ccc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by siyan on 16-01-04.
 */
public class ccc96s3b {

    private static int numOnes( char[] arr ) {
        int count = 0;
        for( char c : arr ) {
            if( c == '1' ) count++;
        }
        return count;
    }

    private static void printBits( int num, int n, int k ) {
        String bits = Integer.toBinaryString( num );
        StringBuffer buf = new StringBuffer();
        char[] arr = bits.toCharArray();
        if( k == numOnes( arr ) ) {
            int x = n - arr.length;
            for( int i = 0; i < x; i ++ ) {
                buf.append( "0" );
            }

            for( char b : arr ) {
                buf.append( b );
            }

            System.out.println( buf.toString() );
        }
    }

    private static void printPair( int n, int k ) {
        char[] bitsMax = new char[n];
        char[] bitsMin = new char[n];
        for(int i = 0; i < n; i++ ) {
            bitsMax[i] = i < k ? '1' : '0';
            bitsMin[n-i-1] = i < k ? '1' : '0';
        }
        int max = Integer.parseInt( String.valueOf(bitsMax), 2);
        int min = Integer.parseInt( String.valueOf(bitsMin), 2);
        System.out.println( "The bit patterns are"  );
        for( int num = max; num >= min; num--) {
            printBits(num, n, k);
        }
        System.out.println( "" );
    }

    public static void  main( String[] args ) {

        Scanner sc = new Scanner( System.in);
        int num = Integer.valueOf(sc.nextLine());
        String[] param = new String[num];

        for( int i = 0; i < num; i++ ) {
            param[i] = sc.nextLine();
        }


        for( int i = 0; i < num; i++ ) {
            String[] pair = param[i].split( " " );
            printPair( Integer.valueOf( pair[0]), Integer.valueOf( pair[1]) );
        }
    }
}

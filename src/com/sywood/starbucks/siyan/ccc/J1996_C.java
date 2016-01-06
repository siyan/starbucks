package com.sywood.starbucks.siyan.ccc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by siyan on 16-01-04.
 */
public class J1996_C {

    private static int numOnes( String bits ) {
        int count = 0;
        for( char c : bits.toCharArray() ) {
            if( c == '1' ) count++;
        }
        return count;
    }

    private static void printBits( int num, int n, int k ) {
        String bits = Integer.toBinaryString( num );
        if( k == numOnes( bits ) ) {
            int x = n - bits.toCharArray().length;
            for( int i = 0; i < x; i ++ ) {
                System.out.print( "0 ");
            }
            for( char b : bits.toCharArray() ) {
                System.out.print( b + " ");
            }
            System.out.println( "" );
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
        System.out.println( max + ", " +  min  );
        for( int num = max; num >= min; num--) {
            printBits(num, n, k);
        }
    }

    public static void  main( String[] args ) {

        Scanner sc = new Scanner( System.in);
        int num = Integer.valueOf(sc.nextLine());
        for( int i = 0; i < num; i++ ) {
            String[] pair = sc.nextLine().split( " " );
            printPair( Integer.valueOf( pair[0]), Integer.valueOf( pair[1]) );
        }
    }
}

package com.sywood.starbucks.siyan.ccc;

import java.util.Scanner;

public class ccc96s3 {
    private static int n;
    private static int k;
    private static char[] A = new char[30];

    private static void  printA( int i, int j ) {
        if ( i == 0 && j == 0 ) {
            for ( int l = 0; l < n; l++ )  {
                System.out.print( A[l] );
            }
            System.out.println( "" );
        }
        else {
            if( j > 0 ) {
                A[n-i] = '1';
                printA( i-1, j-1 );
            }

            if( i > j ) {
                A[n-i] = '0';
                printA( i-1, j );
            }
        }
    }


    public static void  main( String[] args ) {

        Scanner sc = new Scanner( System.in);
        int num = Integer.valueOf(sc.nextLine());
        for( int i = 0; i < num; i++ ) {
            String[] pair = sc.nextLine().split(" ");
            n = Integer.valueOf( pair[0] );
            k = Integer.valueOf( pair[1] );
            System.out.println( "The bit patterns are"  );
            printA( n, k );
        }
    }
}

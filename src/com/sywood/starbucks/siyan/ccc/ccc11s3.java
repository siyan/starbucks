package com.sywood.starbucks.siyan.ccc;

import java.util.Scanner;

/**
 * Created by siyan on 16-01-07.
 */
public class ccc11s3 {
    private static long topCrystalY( int m, long x ) {
        if( m == 0 ) {
            return 0;
        }
        long p_1 = (long) Math.pow( 5, (m - 1) );
        int region = (int)(x / p_1);
        if( region == 0 || region == 4 ) {
            return 0;
        }
        else if( region == 2 ) {
            return 2 * p_1 + topCrystalY( m - 1, x - region * p_1 );
        }
        else {
            return p_1 + topCrystalY( m - 1, x - region * p_1 );
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        for( int i = 0; i < num; i++ ) {
            String[] params = sc.nextLine().split( " " );
            int m = Integer.valueOf( params[0]);
            long x = Long.valueOf( params[1] );
            long y = Long.valueOf( params[2] );
            long topY = topCrystalY( m, x);
            System.out.println( y > topY ? "empty" : "crystal" );
        }
    }
}

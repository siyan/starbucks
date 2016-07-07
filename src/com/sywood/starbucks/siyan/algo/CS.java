package com.sywood.starbucks.siyan.algo;

import java.util.*;

/**
 * Created by siyan on 2016-07-05.
 */
public class CS {

    private static void uva11236() {
        int[] it = new int[4];


        List<int[]> res = new ArrayList<int[]>();
        int cnt = 0;
        for( it[3] = 1; it[3] < 1998; it[3]++ ) {
            for( it[2] = 1; it[2] <= it[3] && it[2] < 1999 - it[3]; it[2]++) {
                for( it[1] = 1; it[1] <= it[2] && it[1] < 2000 - (it[3] + it[2]); it[1]++ ) {
                    for( it[0] = 1; it[0] <= it[1] && it[0] < 2001 - (it[3] + it[2] + it[1] ); it[0]++) {
                        long s = (it[3] + it[2] + it[1] + it[0]) * 1000000;
                        long p = (it[3] * it[2] * it[1] * it[0]);
                        if( s == p ) {
                            cnt++;
                            //System.out.println( s+ " = " + p + ":  " + l + ", " + k + ", " + j + ", " + i + " ==> " + cnt);
                            //System.out.println( it[0] + ", " + it[1] + ", " + it[2] + ", " + it[3] );
                            res.add( it.clone());
                        }
                    }
                }
            }
        }

        for( int[] r : res )  {
            System.out.println( r[0] + ", " + r[1] + ", " + r[2] + ", " + r[3] );
        }
        System.out.println( res.size() + " - " + cnt );
    }

    public static void main( String[] args) {
        uva11236();
    }
}

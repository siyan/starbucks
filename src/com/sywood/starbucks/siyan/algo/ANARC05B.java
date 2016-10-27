package com.sywood.starbucks.siyan.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-10-26.
 */
public class ANARC05B {

    private static int max( int n1, int n2 ) {
        return n1 > n2 ? n1 : n2;
    }

    private static int[] parseString( String s ) {
        String[] ss = s.split( " ");
        int[] h = new int[ ss.length - 1 ];
        for( int i = 0; i < h.length; i++ ) {
            h[i] = Integer.parseInt( ss[i + 1]);
        }
        System.out.println( s );
        return h;
    }

    private static boolean theEnd( int idx1, int idx2, int[] h1, int[] h2 ) {
        if( idx1 < h1.length && idx2 < h2.length) {
            return true;
        }
        else {
            if( h1[h1.length-1] != h2[h2.length-1]) {
                tot += max( subtot1, subtot2 );
            }
            return false;
        }
    }

    static int tot;
    static int subtot1;
    static int subtot2;
    private static int walk( int[] h1, int[] h2) {
        tot = subtot1 = subtot2 = 0;
        int idx1 = 0;
        int idx2 = 0;
        for( ; theEnd( idx1, idx2, h1, h2); ) {
            if( h1[idx1] > h2[idx2] ) {
                subtot2 += h2[idx2++];
            }
            else if ( h1[idx1] < h2[idx2] ) {
                subtot1 += h1[idx1++];
            }
            else {
                tot += max( subtot1, subtot2 );

                subtot1 = h1[idx1++];
                subtot2 = h2[idx2++];
                tot += subtot1;
            }
            System.out.println( tot + " " + idx1 );
        }

        return tot;
    }

    public static void main(String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        for (String line = input.readLine(); line.charAt(0) != '0'; line = input.readLine()) {
            int[] h1 = parseString( line );
            int[] h2 = parseString( input.readLine() );
            System.out.println( "total = " + walk( h1, h2));
        }
    }
}

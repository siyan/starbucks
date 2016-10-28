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
            h[i] = Integer.parseInt( ss[i+1]);
        }
        return h;
    }

    private static boolean theEnd( int idx1, int idx2, int[] helix1, int[] helix2 ) {
        if( idx1 < helix1.length || idx2 < helix2.length) {
            return true;
        }
        else {
            if( helix1[helix1.length-1] != helix2[helix2.length-1]) {
                total += max( subtot1, subtot2 );
            }
            return false;
        }
    }

    static int total;
    static int subtot1;
    static int subtot2;

    private static int walk( int[] helix1, int[] helix2 ) {
        total = subtot1 = subtot2 = 0;

        for( int idx1 = 0, idx2 = 0; theEnd( idx1, idx2, helix1, helix2 ); ) {
            if( idx2 < helix2.length && ( idx1 == helix1.length || helix1[idx1] > helix2[idx2]  ) ) {
                subtot2 += helix2[idx2++];
            }
            else if ( idx1 < helix1.length && ( idx2 == helix2.length || helix1[idx1] < helix2[idx2] ) ) {
                subtot1 += helix1[idx1++];
            }
            else if ( helix1[idx1] == helix2[idx2] )  {
                total += max( subtot1, subtot2 );
                subtot1 = subtot2 = 0;
                idx1++;
                total += helix2[idx2++];
            }
            else {
                System.out.println( "should never be here, something wrong" );
            }
        }

        return total;
    }

    public static void main(String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        for (String line = input.readLine(); line.charAt(0) != '0'; line = input.readLine()) {
            int[] h1 = parseString( line );
            int[] h2 = parseString( input.readLine() );
            System.out.println( walk( h1, h2));
        }
    }
}

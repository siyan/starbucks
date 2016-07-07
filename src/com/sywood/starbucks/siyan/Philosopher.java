package com.sywood.starbucks.siyan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-07-06.
 */
public class Philosopher {

    static boolean isConflict( int d, int u ) {

        // conflict
        if( _essays[d] > _essays[u]) {
            return true;
        }

        // first time used
        if( _essays[d] == _essays[u] ){
            _tail = _essays[d] + 1;
            for( int i = 0; i < _essays.length; i++ ) {
                if( i != d) _essays[i] = _tail;
            }
        }

        return false;
    }

    static int _tail;
    static int[] _essays;

    public static void main( String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split( " " );
        int n = Integer.parseInt( line[0] );
        int m = Integer.parseInt( line[1] );

        _essays = new int[n];

        for( int i = 0; i < m; i++ ) {
            String[] du = input.readLine().split( " " );
            int d = Integer.parseInt( du[0] );
            int u = Integer.parseInt( du[1] );
            if( isConflict( d, u ) ) {
                System.out.println( '0' );
                return;
            }
        }

        System.out.println( _tail + 1 == _essays.length ? "1" : "2" );

    }
}

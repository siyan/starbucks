package com.sywood.starbucks.siyan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
5 4
1 5
5 2
3 2
4 3

5 4
3 1
4 2
1 5
5 4

2 2
1 2
2 1
 */
public class Philosopher {

    static boolean isConflict( int d, int u ) {

        // conflict
        if( _essays[d] > _essays[u] && _essays[u] > 0 ) {
            return true;
        }

        //already in order
        if( _essays[d] < _essays[u] && _essays[d] > 0 ) {
            return false;
        }

        // first time define
        if( _essays[d] == 0 ) {
            _essays[d] = 1;
            if( _essays[u] == 0 ) {
                _essays[u] = 2;
            }

            if( _essays[u] == 1 ) {
                for( int i = 0; i < _essays.length; i++ ) {
                    if( _essays[i] > 1 ) _essays[i] +=1;
                }
                _essays[u] = 2;
            }

        }

        // first time used
        if( _essays[u] == 0 ){
            _essays[u] = _essays[d] + 1;
        }

        return false;
    }

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
            if( isConflict( d-1, u-1 ) ) {
                System.out.println( '0' );
                return;
            }
        }
        int x = 0;
        for( int e : _essays) {
            if( x < e ) x = e;
        }
        System.out.println( x == _essays.length ? "1" : "2" );

    }
}

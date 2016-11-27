package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-04-12.
 */
public class ccc02s4 {

    static String[] _names;
    static int[]    _speeds;
    static int[]    _best;
    static int      M;

    static int max( int a, int b ) {
        return a > b ? a : b;
    }

    static int min( int a, int b ) {
        return a > b ? b : a;
    }

    static int groupSpeed( int start, int end ) {
        int slowest = 0;
        int group = 0;
        for( int i = start - 1; i < end; i++ ) {
            slowest = max( slowest, _speeds[i]);
            if( slowest == _speeds[i] ) {
                group = i;
            }
        }
        for( int i = start - 1; i <= group; i++ ) {
            System.out.print( _names[i]);
        }

        System.out.println("");
        return slowest;
    }

    static void dp() {

        _best[0] = 0;
        _best[1] = _speeds[0];
        for( int i = 2; i <= _names.length; i++ ) {
            int speed = 9999999;
            for( int j = max( 0, i - M + 1) ; j <= i ; j++) {
                int gs = groupSpeed( j, i ) + _best[j-1];
                speed = min( gs, speed);
                //System.out.println(j + "-" + i + " ==> " + gs + ", " + speed );
            }
            _best[i] = speed;
        }

        System.out.println( "Total Time: " + _best[_names.length]);

    }

    public static void main(String[] args) {

        FileReader fr = null;
        try {
            BufferedReader textReader = new BufferedReader(new InputStreamReader(System.in));
            M = Integer.valueOf(textReader.readLine());
            int Q = Integer.valueOf(textReader.readLine());

            _names  = new String[Q];
            _speeds = new int[Q];
            _best   = new int[Q+1];

            for (int i = 0; i < Q; i++) {
                _names[i] = textReader.readLine();
                _speeds[i] = Integer.valueOf(textReader.readLine());
            }

            dp();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

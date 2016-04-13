package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by siyan on 2016-04-12.
 */
public class ccc02s4 {

    static String[] _names;
    static int[]    _speeds;
    static int[]    _best;
    static int      M;

    static int groupSpeed( int start, int end ) {
        int slowest = 0;
        for( int i = start - 1; i < end; i++ ) {
            slowest = Math.max( slowest, _speeds[i]);
        }
        return slowest;
    }

    static void dp() {

        _best[0] = 0;
        _best[1] = _speeds[0];
        for( int i = 2; i < _names.length; i++ ) {
            int speed = 9999999;
            for( int j = Math.max( 0, i - M + 1) ; j <= i ; j++) {
                int gs = groupSpeed( j, i ) + _best[j-1];
                speed = Math.min( gs, speed);
                //System.out.println(j + "-" + i + " ==> " + gs + ", " + speed );
            }
            _best[i] = speed;
        }

        System.out.println( _best[_names.length - 1]);

    }

    public static void main(String[] args) {

        FileReader fr = null;
        try {
            fr = new FileReader("data/bridge.in");
            BufferedReader textReader = new BufferedReader(fr);
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

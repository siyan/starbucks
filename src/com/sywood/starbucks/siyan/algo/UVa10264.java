package com.sywood.starbucks.siyan.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-08-01.
 */
public class UVa10264 {

    private static void potent( int dim, byte[] weights ) {
        short[] potency = new short[weights.length];
        for( int d = 0; d < dim; d++ ) {
                for( int w = 0 ; w < weights.length; w += 2 ) {
                    int a = w;
                    int b = w + (1<<d);
                    int x = (1<<d);
                    System.out.println("(" + a + ", " + b + ") " + x);
                }
        }
    }

    public static void main( String[] args ) throws IOException {

        BufferedReader textReader = new BufferedReader(new InputStreamReader(System.in));
        for (String dim = textReader.readLine(); dim != null; dim = textReader.readLine()) {
            int d = Integer.parseInt( dim );
            byte[] wt = new byte[2 << (d -1)];
            for( int v = 0; v < wt.length; v++ ) {
                String val = textReader.readLine();
                wt[v] = (byte)(Integer.valueOf( val ) - 127);
            }
            potent( d, wt );
        }
    }
}

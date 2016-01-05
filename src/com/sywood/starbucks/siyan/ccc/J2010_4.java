package com.sywood.starbucks.siyan.ccc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by siyan on 15-12-26.
 */
public class J2010_4 {

    private static int intDiff( String s1, String s2) {
        return Integer.valueOf( s1 ) - Integer.valueOf( s2 );
    }
    public static void main(String[] args ) {
        Scanner sc = new Scanner( System.in);
        for( String line = sc.nextLine(); !"0".equals( line ); line = sc.nextLine() ) {
            String[] degrees = line.split( " " );
            //System.out.println( degrees );
            boolean matched = true;
            for( int p = 1; p <= degrees.length / 2 ; p++ ) {
                int c = degrees.length / p - p;
                for (int q = 0; q < c - 1; q++) {
                    int g1 = intDiff( degrees[q + 1], degrees[q]);
                    int g2 = intDiff( degrees[p + q + 1], degrees[p + q]);
                    if (g1 != g2) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    System.out.println(p + ": " + matched);
                    break;
                }
            }

            if(!matched) System.out.println("no match");

        }
    }
}

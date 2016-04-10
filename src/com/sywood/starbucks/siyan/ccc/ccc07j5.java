package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-04-09.
 */
public class ccc07j5 {

    static int[] ways;
    static int[] motel;

    static int recu(int A, int B, int curr ) {
        int stay = curr - 1;
        while (stay > -1 && motel[curr] - motel[stay] < A) stay--;
        if( stay <= 0 ) {
            return (motel[curr] - motel[stay] < A) ? 0 : 1;
        }
        else {

            while (stay > -1 && motel[curr] - motel[stay] < B) {
                if( motel[curr] - motel[stay] < B ) {
                    if (ways[stay] == 0) {
                        ways[stay] = recu(A, B, stay);
                    }
                    ways[curr] += ways[stay];
                }
                stay--;
            }
            return ways[curr];
        }
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] M = br.readLine().split(",");
        String[] M = "0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000".split(",");
        ways = new int[M.length];
        motel = new int[M.length];
        //br.close();
        for( int i = 0; i < M.length; i++ ) {
            motel[i] = Integer.parseInt( M[i].trim());
        }

        recu(970, 1300, M.length -1);
        System.out.println( ways[M.length - 1] );

    }
}

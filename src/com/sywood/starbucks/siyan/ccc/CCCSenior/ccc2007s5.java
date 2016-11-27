package com.sywood.starbucks.siyan.ccc.CCCSenior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-11-26.
 */
public class ccc2007s5 {

    private static int max( int a, int b) { return a > b ? a : b; }

    private static int[] DOWN_PIN_SUM;
    private static int[] MAX_PINS;
    private static int[] MAX_SUM;

    private static int downPinSum( int[] pins, int startPos,   int ballWidth) {
        if(DOWN_PIN_SUM[startPos] > 0 ) return  DOWN_PIN_SUM[startPos];

        int num = 0;
        for( int j = 0; j < ballWidth; j++ ) {
            int pos = j + startPos;
            num += pins[pos];
        }
        DOWN_PIN_SUM[startPos] = num;
        return num;
    }

    private static int maxPins( int[] pins, int startPos, int ballWidth ) {
        if( MAX_PINS[startPos] > 0 ) return MAX_PINS[startPos];

        int maxNum = 0;
        for( int currPos = startPos; currPos < pins.length - ballWidth; currPos++ ) {
            int dPins = downPinSum( pins, currPos, ballWidth);

            maxNum = max( maxNum, dPins );
        }
        MAX_PINS[startPos] = maxNum;
        return maxNum;
    }

    private static int recuPins( int[] pins, int startPos, int ballWidth, int numBalls ) {
        if( MAX_SUM[startPos] > 0 ) return MAX_SUM[startPos];
        if( numBalls == 1 ) {
            return maxPins( pins, startPos, ballWidth );
        }
        else {
            int maxSum = 0;
            for( int i = pins.length - numBalls * ballWidth - 1; i >= 0 ; i--  ) {
                int currSum = downPinSum( pins, i,   ballWidth);
                maxSum = max( maxSum, currSum + recuPins( pins, i, ballWidth, numBalls - 1 ));
            }
            MAX_SUM[startPos] = maxSum;
            return maxSum;
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt( input.readLine() );
        for( int c = 0; c < numCases; c++ ) {
            String[] tokens = input.readLine().split( " ");
            int numPins = Integer.parseInt( tokens[0] );
            int numBalls = Integer.parseInt( tokens[1] );
            int ballWidth = Integer.parseInt( tokens[2] );
            int[] pins = new int[numPins];
            DOWN_PIN_SUM = new int[numPins];
            MAX_PINS = new int[numPins];
            MAX_SUM = new int[numPins];
            for( int p = 0; p < numPins; p++ ) {
                pins[p] = Integer.parseInt( input.readLine() );
            }

            System.out.println( recuPins(pins, 0, ballWidth, numBalls) );
        }

    }
}

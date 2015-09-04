package com.sywood.starbucks.siyan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by siyan on 9/3/15.
 */
public class Cards {

    private static int cardScore( String card ) {
        if( "ace".equals( card )) return 4;
        else if ( "king".equals( card )) return 3;
        else if ( "queen".equals( card )) return 2;
        else if ( "jack".equals( card )) return 1;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("data/card.in");
        BufferedReader textReader = new BufferedReader(fr);

        int[] points      = new int[2];
        int currentPlayer = 0;
        int winningPlayer = 0;
        int winningScore  = 0;
        int countDown     = -1;

        for (String card = textReader.readLine(); card != null; card = textReader.readLine()) {
            int score = cardScore( card );
            if( score > 0 ) {
                countDown = score;
                winningScore = score;
                winningPlayer = currentPlayer;
            }
            else {
                countDown--;
            }

            if( countDown == 0 ) {
                points[winningPlayer] = points[winningPlayer] + winningScore;
            }

            //System.out.println(currentPlayer + ": " + card + " -(" + points[0] + ", " + points[1] + ")");
            currentPlayer = (currentPlayer + 1 ) % 2;
        }

        System.out.println( "Player A: " + points[0] + " points.");
        System.out.println( "Player B: " + points[1] + " points.");
    }

}

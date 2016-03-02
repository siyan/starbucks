package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by siyan on 16-03-01.
 */
public class ccc05j5 {

    static boolean isMonkeyWord( String word ) {

        if( "A".equalsIgnoreCase( word ) ) {
            return true;
        }
        else if( word.startsWith( "AN")) {
            return isMonkeyWord( word.substring( 2 ));
        }
        else if( word.startsWith( "B") && word.endsWith("S")) {
            return isMonkeyWord( word.substring( 1, word.length() -1 ) );
        }
        else if( word.startsWith( "B") && word.contains("SN")) {
            int idxS = word.indexOf( "SN");
            String w1 = word.substring( 1, idxS);
            String w2 = word.substring( idxS + 2 );
            return isMonkeyWord( w1 ) && isMonkeyWord( w2 );
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("data/banana.in"));
        String word = input.readLine();
        while (!word.equals("X")){
            if (isMonkeyWord(word)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            word = input.readLine();
        }
    }
}

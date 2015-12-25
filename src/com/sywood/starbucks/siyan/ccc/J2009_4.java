package com.sywood.starbucks.siyan.ccc;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by siyan on 15-12-23.
 */
public class J2009_4 {

    // extra dots means in addition to one dot should be there between words
    private static void print( int extraDots, List<String> words ) {

        if(words.size() == 1 ) {
            // what does this block do?
            System.out.print(words.get(0));
            for( int i = 0; i < extraDots; i++ ) {
                System.out.print(".");
            }
        }
        else {
            // why words.size() - 1?
            int totDots = extraDots + (words.size() - 1);
            int basicDots = totDots / (words.size() - 1);
            int numSpaceHasMoreDot = totDots - basicDots * (words.size() - 1);
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                System.out.print(word);
                if (i < words.size() - 1) {
                    for (int j = 0; j < basicDots; j++) {
                        System.out.print(".");
                    }
                    if (numSpaceHasMoreDot > 0) {
                        System.out.print(".");
                        numSpaceHasMoreDot -= 1;
                    }
                }
            }
        }

        System.out.print( "\n");
        words.clear();
    }

    public static void main( String[] args ) {
        String[] allWords = "WELCOME TO CCC GOOD LUCK TODAY".split( " " );
        List<String> wordsInALine = new LinkedList<String>();


        Scanner input = new Scanner(System.in);
        int w = input.nextInt();

        int currPos = 0;

        for( String word : allWords ) {
            if(( currPos + word.length()) > w ) {
                // why currPos + 1?
                print(w - currPos + 1, wordsInALine);
                currPos = 0;
            }
            wordsInALine.add(word);
            currPos += (word.length() + 1);
        }

        // what is this for?
        if( currPos > 0) print( w - currPos + 1, wordsInALine);


    }
}

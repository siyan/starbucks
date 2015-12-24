package com.sywood.starbucks.siyan.ccc;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by siyan on 15-12-23.
 */
public class J2009_4 {

    private static void print( int extraDots, List<String> line ) {

        if(line.size() == 1 ) {
            System.out.print(line.get(0));
            for( int i = 0; i < extraDots; i++ ) {
                System.out.print(".");
            }
        }
        else {
            int totDots = extraDots + (line.size() - 1);
            int basicDots = totDots / (line.size() - 1);
            int numSpaceHasMoreDot = totDots - basicDots * (line.size() - 1);
            for (int i = 0; i < line.size(); i++) {
                String word = line.get(i);
                System.out.print(word);
                if (i < line.size() - 1) {
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
        line.clear();
    }

    public static void main( String[] args ) {
        String[] words = "WELCOME TO CCC GOOD LUCK TODAY".split( " " );
        List<String> line = new LinkedList<String>();


        Scanner input = new Scanner(System.in);
        int w = input.nextInt();

        int currPos = 0;

        for( String word : words ) {
            if(( currPos + word.length()) > w ) {
                print(w - currPos, line);
                currPos = 0;
            }
            line.add( word );
            currPos += (word.length() + 1);
        }

        if( currPos > 0) print( w - currPos, line);


    }
}

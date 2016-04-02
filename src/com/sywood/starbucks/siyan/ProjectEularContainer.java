package com.sywood.starbucks.siyan;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by siyan on 2016-04-02.
 */
public class ProjectEularContainer {


    static int[] ones = new int[]{3, 3, 5, 4, 4, 3, 5, 5, 4};
    static  int[] teens = new int[]{6, 6, 8, 8, 7, 7, 9, 8, 8};
    static int[] tens = new int[]{3, 6, 6, 5, 5, 5, 7, 6, 6};

    static void p017() {

        int sumOnes  = 0;
        int sumTeens = 0;
        int sumTens  = 0;
        for( int i = 0; i < 9; i++) {
            sumOnes  += ones[i];
            sumTeens += teens[i];
            sumTens  += tens[i];
        }

        int sum99 = sumOnes + sumTeens + sumTens;

        for( int i = 1; i < 9; i++ ) {
            sum99 += 9 * tens[i] + sumOnes;
        }

        System.out.println( sum99 );

        int sumThousand = sum99;
        for( int i = 0; i < 9; i++ ) {
            sumThousand += ones[i] + "HUNDRED".length();
            sumThousand += 99 * ( ones[i] + "HUNDRED".length() + "AND".length() ) + sum99;
        }

        sumThousand += "ONETHOUSAND".length();

        System.out.println( sumThousand);
    }

    public static void main(String[] args ) {

        p017();
    }
}

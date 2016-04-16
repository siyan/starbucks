package com.sywood.starbucks.siyan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siyan on 2016-04-02.
 */
public class ProjectEularContainer {


    static int[] ones = new int[]{3, 3, 5, 4, 4, 3, 5, 5, 4};
    static int[] teens = new int[]{6, 6, 8, 8, 7, 7, 9, 8, 8};
    static int[] tens = new int[]{3, 6, 6, 5, 5, 5, 7, 6, 6};

    static void p017() {

        int sumOnes = 0;
        int sumTeens = 0;
        int sumTens = 0;
        for (int i = 0; i < 9; i++) {
            sumOnes += ones[i];
            sumTeens += teens[i];
            sumTens += tens[i];
        }

        int sum99 = sumOnes + sumTeens + sumTens;

        for (int i = 1; i < 9; i++) {
            sum99 += 9 * tens[i] + sumOnes;
        }

        int sumThousand = sum99;
        for (int i = 0; i < 9; i++) {
            sumThousand += ones[i] + "HUNDRED".length();
            sumThousand += 99 * (ones[i] + "HUNDRED".length() + "AND".length()) + sum99;
        }

        sumThousand += "ONETHOUSAND".length();

        System.out.println(sumThousand);
    }

    static void p018() throws IOException {

        FileReader fr = new FileReader("data/p018.in");
        BufferedReader reader = new BufferedReader(fr);

        // first line has only one number
        String line = reader.readLine();
        int[] prevMax = new int[1];
        prevMax[0] = Integer.parseInt( line );

        for( line = reader.readLine(); line != null; line = reader.readLine()) {
            String[] nums = line.split( " ");
            int[] currMax = new int[nums.length];

            // first and last number are single parent
            currMax[0] = Integer.parseInt( nums[0] ) + prevMax[0];
            currMax[prevMax.length] = Integer.parseInt( nums[prevMax.length] ) + prevMax[prevMax.length-1];

            for( int i = 1; i < prevMax.length; i++ ) {
                currMax[i] = Math.max( prevMax[i-1], prevMax[i]) + Integer.parseInt( nums[i] );
            }
            prevMax = currMax;
        }

        int x = 0;
        for( int j : prevMax  ) {
            x = Math.max( x, j );
        }
        System.out.println( x );
    }

    static void p019() {
        int numSundays = 0;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 1901;
        int dayNum = 2;

        while (year < 2001) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                months[1] = 29;
            } else {
                months[1] = 28;
            }

            for (int month : months) {
                for (int i = 1; i <= month; i++) {
                    dayNum++;
                    if (dayNum > 6) {
                        dayNum = 0;
                        if (i == 1) {
                            numSundays++;
                        }
                    }
                }
            }

            year++;
        }
        System.out.println(numSundays);
    }

    static int p26recuringDigit( int n ) {
        Map<Integer,Integer> stateToIter = new HashMap<Integer,Integer>();
        int state = 1;
        int iter = 0;
        while (!stateToIter.containsKey(state)) {
            stateToIter.put(state, iter);
            state = state * 10 % n;
            iter++;
            System.out.println( n + ": " + state + " - " + iter);
        }
        System.out.println ( " ====> " + (iter -stateToIter.get(state)));
        return iter - stateToIter.get(state);
    }

    static void p26() {
        for( int i = 1; i < 20; i = i + 1 ) {
            String a = Double.toString( 1.0d / i );

            System.out.println( i + ": " + a);
            if( a.length() > 1 )
                p26recuringDigit( i );
        }

    }

    static void p28() {
        int count = 2;
        int LAYER = 2;
        for( int i = 0; i <= LAYER; i++ ) {
            for( int j = 0; j < 4; j++ ) {
                for( int k = 1; k <= 2 * i; k++ ) {
                    int x = LAYER;
                    int y = LAYER;
                    switch( j ) {
                        case 0:
                            x += i;
                            y += i - k;
                            break;
                        case 1:
                            x += i - k;
                            y -= i;
                            break;
                        case 2:
                            x -= i;
                            y += k - i;
                            break;
                        case 3:
                            x += k - i;
                            y += i;
                            break;
                    }
                    System.out.println("(" + x + ", " + y + ") = " + count);
                    count++;
                }
            }
        }

    }

    static void p28b() {
        int number = 1;
        long sum = number;
        int MAX_LAYER = 500;
        for (int layer = 1; layer <= MAX_LAYER; layer++) {
            int incr = layer * 2 ;
            for (int direction = 0; direction < 4; direction++) {
                number += incr;
                sum += number;
                //System.out.println( number + " -> " + sum);
            }
        }

        System.out.println( sum );
    }

    public static void main(String[] args) {


        //p017();
        //p018();
        //p019();
        p28b();

    }
}

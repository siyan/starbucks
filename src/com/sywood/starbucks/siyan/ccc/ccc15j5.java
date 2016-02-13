package com.sywood.starbucks.siyan.ccc;

import java.util.Scanner;

/**
 * Created by siyan on 16-02-12.
 */
public class ccc15j5 {

    static int counter = 0;

    static void recPi( int n, int k, int min ) {
        if( k == 1 || n == k ) {
            counter++;
            return;
        }
        else {
            int max = n / k;
            for (int i = min; i <= max; i++) {
                recPi(n - i, k - 1, i);
            }
        }
    }


    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        recPi( n, k, 1 );
        System.out.println( counter );
    }
}

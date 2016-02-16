package com.sywood.starbucks.siyan.ccc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by siyan on 16-02-15.
 */
public class ccc11j5 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ways = new int[num];
        for( int i = 0; i< num; i++ ) ways[i] = 1;

        for( int i = 0; i < num - 1; i++ ) {
            int y = sc.nextInt() - 1;
            ways[y] = ways[y] * ( 1 + ways[i]);
        }

        System.out.println(ways[num-1]);
    }
}

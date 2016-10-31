package com.sywood.starbucks.ben.HackerRank.WalmarCodesprint;

import java.util.Scanner;

/**
 * Created by Ben on 2016-10-29.
 */
public class HikingSelfies {
    public static void main(String[] args)throws Exception{
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int x = input.nextInt();

        System.out.println(Math.abs((1<<N)-1-x));
    }
}

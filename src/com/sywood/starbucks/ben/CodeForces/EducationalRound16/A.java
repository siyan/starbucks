package com.sywood.starbucks.ben.CodeForces.EducationalRound16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-22.
 */
public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = input.readLine();
        int col = line.charAt(0)-'a';
        int row = line.charAt(1)-'1';
        int numMoves = 8;
        if ((col == 0 || col == 7) && (row == 0 || row == 7)){
            numMoves = 3;
        }else if (col == 0 || col == 7){
            numMoves = 5;
        }else if (row == 0 || row == 7){
            numMoves = 5;
        }
        System.out.println(numMoves);
    }
}

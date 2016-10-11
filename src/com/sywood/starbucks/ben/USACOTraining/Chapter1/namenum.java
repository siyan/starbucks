package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Ben on 2016-10-10.
 */
public class namenum {
    private static ArrayList<String> valid = new ArrayList<String>();

    private static void generate()throws Exception{
        BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream("dict.txt")));

        String inp = stream.readLine();

        while(inp != null){
            valid.add(inp);
            inp = stream.readLine();
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        String digits = input.readLine();
        int N = digits.length();

        char[][] values = new char[][]{{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N','O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};

        input.close();
        printer.close();
    }
}

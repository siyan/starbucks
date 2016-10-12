//package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.ArrayList;

/**
 ID: benbli
 LANG: JAVA
 TASK: namenum
 */
public class namenum {
    private static ArrayList<String> valid = new ArrayList<String>();

    private static char[][] values = new char[][]{{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N','O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};
    private static ArrayList<String> combos = new ArrayList<String>();
    private static long counter = 0;


    private static void generate()throws Exception{
        BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream("dict.txt")));

        String inp = stream.readLine();

        while(inp != null){
            valid.add(inp);
            inp = stream.readLine();
        }
    }


    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("namenum.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        String digits = input.readLine();
        generate();

        if(counter == 0){

            printer.println("NONE");
            printer.close();
        }


        input.close();
    }
}

package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

/**
 * UVa's only sole linkedList question.
 */
public class UVa11988 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        ArrayDeque<String> letters;
        boolean begin; // checks if to add front or end of array.
        String line = input.readLine();
        String temp;
        while(line != null && !line.equals("")){
            letters = new ArrayDeque<>();
            char[] stuff = line.toCharArray();
            temp = "";
            begin = false;
            for(char thing : stuff){
                if(thing == '['){
                    if (begin){
                        letters.addFirst(temp);
                    }else{
                        letters.addLast(temp);
                    }
                    temp = "";
                    begin = true;
                }else if (thing == ']'){
                    if (begin){
                        letters.addFirst(temp);
                    }else
                        letters.addLast(temp);
                    temp = "";
                    begin = false;
                }else
                    temp += thing;
            }

            if(!temp.equals("")){
                if(begin){
                    letters.addFirst(temp);
                }else
                    letters.addLast(temp);
            }

            for(String lett : letters){
                printer.print(lett);
            }
            printer.print("\n");
            line = input.readLine();
        }
        printer.close();
    }
}
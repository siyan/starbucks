package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Third underlined Stack question
 */
public class UVa1062 {
    private static ArrayList<Stack<Character>> addToStacks(char item, ArrayList<Stack<Character>> stacks){
        boolean found = false;
        for(Stack<Character> stack : stacks){
            if (stack.peek() >= item){
                stack.push(item);
                found = true;
                break;
            }
        }
        if (!found){
            Stack<Character> temp = new Stack<>();
            temp.push(item);
            stacks.add(temp);
        }
        return stacks;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        ArrayList<Stack<Character>> stacks;
        char[] letters;
        int counter = 1;
        while(!line.equals("end")){
            letters = line.toCharArray();
            stacks = new ArrayList<>();
            for(char letter : letters){
                stacks = addToStacks(letter, stacks);
            }
            printer.printf("Case %d: %d\n", counter++, stacks.size());
            line = input.readLine();
        }
        printer.close();
    }
}

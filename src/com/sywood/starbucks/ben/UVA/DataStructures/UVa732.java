package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Second underlined stack question
 */
public class UVa732 {
    private static String line;
    private static PrintWriter printer = new PrintWriter(System.out);
    private static void recurse(String current, Stack<Character> stack, String target, String process){
        if (stack.isEmpty() && target.equals("")){
            printer.println(process);
        }else if (!current.equals("")){
            stack.push(current.charAt(0));
            recurse(current.substring(1), stack, target, process+ "i ");
        }else if (!stack.isEmpty()){
            char t = stack.pop();
            if (t == target.charAt(0)){
                recurse(current, stack, target.substring(1), process + "o ");
            }
        }

    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        line = input.readLine();
        String target;
        while(line != null && !line.equals("")){
            target = input.readLine();
            stack = new Stack<>();
            stack.push(line.charAt(0));
            printer.println("[");
            recurse(line.substring(1), stack, target, "i ");
            printer.println("]");
        }
    }
}

package com.sywood.starbucks.ben.DadsWork;
import java.io.*;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args){
        String infix = "(2+((3+4)*(5*6)))";
        Stack<Character> unused = new Stack<>();
        for (int i = 0; i <infix.length() ; i++) {
            char current = infix.charAt(i);
            if (current == '(' && !unused.empty()){
                System.out.print(unused.pop());
            }else if (Character.isDigit(current)){
                System.out.print(current);
            }else if (current != '(' && current != ')'){
                unused.push(current);
            }
        }
        while (!unused.empty()){
            System.out.print(unused.pop());
        }
    }
}

package com.sywood.starbucks.siyan.ccc;

import java.util.Stack;

public class J2008_4 {

    public static void main(String[] args) {

        String formula = "--3+219";
        Stack<Character> ops = new Stack<>();

        for( char c : formula.toCharArray() ) {
            if(Character.isDigit(c)) {
                System.out.print(c);
                while ( !ops.isEmpty() && Character.isDigit(ops.peek())) {
                    ops.pop();
                    System.out.print(ops.pop());
                }
            }
            ops.push( c );
        }
    }
}

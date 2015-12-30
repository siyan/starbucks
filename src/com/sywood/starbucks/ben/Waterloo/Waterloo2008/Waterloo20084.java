package com.sywood.starbucks.ben.Waterloo.Waterloo2008;
import java.util.Scanner;
import java.util.Stack;

public class Waterloo20084 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String prefix = input.next();
        Stack<Character> operations = new Stack<Character>();
        for (char part : prefix.toCharArray()){
            if (Character.isDigit(part)){
                System.out.print(part);
            }
            while (!operations.isEmpty() && Character.isDigit(operations.peek())){
                operations.pop();
                System.out.print(operations.pop());
            }
            operations.push(part);
        }
    }
}

package com.sywood.starbucks.ben.Waterloo2013;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20133 {
    private static boolean isDis(String a){
        boolean real = true;
        ArrayList b = new ArrayList(a.length());

        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.charAt(i))){
                real = false;
            }else{
                b.add(a.charAt(i));
            }
        }

        return real;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inp = input.next();
        while (!isDis(inp)){
            inp = String.valueOf(Integer.parseInt(inp)+1);
        }
        System.out.print(inp);
    }
}

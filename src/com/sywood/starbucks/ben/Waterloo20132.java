package com.sywood.starbucks.ben;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20132 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList b = new ArrayList(7);
        b.add('I');
        b.add('O');
        b.add('S');
        b.add('H');
        b.add('Z');
        b.add('X');
        b.add('N');
        String word = input.next();
        boolean a = true;
        for (int i = 0; i < word.length(); i++) {
            if (!b.contains(word.charAt(i))){
                a = false;
            }
        }
        if (a){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }
}

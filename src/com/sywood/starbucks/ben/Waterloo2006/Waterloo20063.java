package com.sywood.starbucks.ben.Waterloo2006;
import java.util.Scanner;

public class Waterloo20063 {
    private static int[] keyPress(char letter){
        char[] first = new char[]{'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        char[] second = new char[]{'b', 'e', 'h', 'k', 'n', 'q', 'u', 'x'};
        char[] third = new char[]{'c', 'f', 'i', 'l', 'o', 'r', 'v', 'y'};
        char[] fourth = new char[]{' ', ' ', ' ', ' ', ' ', 's', ' ', 'z'};
        for (int i = 0; i < first.length; i++) {
            if (first[i] == letter){
                return new int[]{i, 1};
            }else if (second[i] == letter){
                return new int[]{i, 2};
            }else if (third[i] == letter){
                return new int[]{i, 3};
            }else if (fourth[i] == letter){
                return new int[]{i, 4};
            }
        }
        return new int[]{20, 5};
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        while (!word.equals("halt")){
            int seconds = 0;
            int previous = -1;
            for (char letter : word.toCharArray()){
                int[] curr = keyPress(letter);
                if (curr[0] == previous){
                    seconds += 2;
                }
                seconds += curr[1];
                previous = curr[0];
            }
            System.out.println(seconds);
        }
    }
}

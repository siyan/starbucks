package com.sywood.starbucks.ben.Waterloo2004;
import java.util.ArrayList;
import java.util.Scanner;

public class Waterloo20044 {
    private static int index(char letter){
        char[] alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int index = 0;
        int ret = -1;
        for (char let : alph){
            if (letter == let){
                ret = index;
            }
            index ++;
        }
        return ret;
    }
    private static char encode(char letter, int point){
        char[] alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int index = index(letter);
        index += point;
        if (index > 25){
            index -= 25;
        }
        return alph[index];
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String coder = input.nextLine();
        String word = input.nextLine();
        String coded = "";
        ArrayList<Character> letters = new ArrayList<>();
        for (char letter : word.toCharArray()){
            if (Character.isAlphabetic(letter)){
                letters.add(letter);
            }
        }
        for (int i = 0; i < letters.size(); i++) {
            int index = index(coder.charAt(i%coder.length()));
            char letter = encode(letters.get(i), index);
            coded += letter;
        }
        System.out.println(coded);
    }
}

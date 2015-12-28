package com.sywood.starbucks.ben.Waterloo2005;
import java.util.Scanner;

public class Waterloo20074 {
    private static String remove(String rem){
        String ret = "";
        for (char letter: rem.toCharArray()){
            if (Character.isAlphabetic(letter)){
                ret += letter;
            }
        }
        return ret;
    }
    private static String reverse(String rev){
        String ret = "";
        char[] letters = rev.toCharArray();
        for (int i = letters.length-1; i > -1; i--) {
            ret += letters[i];
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first phrase>");
        String first = remove(input.nextLine());
        System.out.print("Enter second phrase>");
        String second = reverse(remove(input.nextLine()));
        if (first.equals(second)){
            System.out.println("Is an anagram.");
        }else{
            System.out.println("Is not an anagram.");
        }
    }
}

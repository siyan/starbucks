package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20074 {
    private static ArrayList<Character> remove(String rem){
        ArrayList<Character> ret = new ArrayList<>();
        for (char letter: rem.toCharArray()){
            if (Character.isAlphabetic(letter)){
                ret.add(letter);
            }
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first phrase>");
        ArrayList<Character> first = remove(input.nextLine());
        Collections.sort(first);
        System.out.print("Enter second phrase>");
        ArrayList<Character> second = remove(input.nextLine());
        Collections.sort(second);
        boolean anagram = true;
        if (first.size() == second.size()){
            for (int i = 0; i < first.size(); i++) {
                if (first.get(i) != second.get(i)){
                    anagram = false;
                }
            }
        }else{
            anagram = false;
        }
        if (anagram){
            System.out.println("Is an anagram.");
        }else{
            System.out.println("Is not an anagram.");
        }
    }
}

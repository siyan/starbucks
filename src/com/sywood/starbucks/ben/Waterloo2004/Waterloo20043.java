package com.sywood.starbucks.ben.Waterloo2004;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20043 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int first = Integer.parseInt(input.nextLine());
        int second = Integer.parseInt(input.nextLine());
        ArrayList<String> firstWord = new ArrayList<>();
        ArrayList<String> secondWord = new ArrayList<>();
        for (int i = 0; i < first; i++) {
            firstWord.add(input.nextLine());
        }
        for (int i = 0; i < second; i++){
            secondWord.add(input.nextLine());
        }
        for (String word1 : firstWord){
            for (String word2 : secondWord){
                System.out.println(word1 + " as " + word2);
            }
        }
    }
}

package com.sywood.starbucks.ben.Waterloo2009;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20094 {
    public static String addDot(ArrayList<String> words, int w, int lineSum){
        String ret = "";
        int spaces = words.size()-1;
        int remain = w-lineSum;


        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int w = input.nextInt();
        ArrayList<String> word = new ArrayList<>();
        ArrayList<String> lineWords = new ArrayList<>();
        word.add("WELCOME");
        word.add("TO");
        word.add("CCC");
        word.add("GOOD");
        word.add("LUCK");
        word.add("TODAY");
        int lineSum = 0;
        for (int i = 0; i < 7; i++) {
            if (lineSum + word.get(i).length() < w){
                lineSum += word.get(i).length();
                lineWords.add(word.get(i));
            }else{
                lineSum = 0;
                lineWords = new ArrayList<>();
            }
        }
    }
}

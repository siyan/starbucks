package com.sywood.starbucks.ben.Waterloo2009;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20094 {
    public static String addDot(ArrayList<String> words, int w, int lineSum){
        String ret = "";
        if (words.size() == 1){
            ret += words.get(0);
            for (int i = 0; i < w-lineSum; i++) {
                ret += ".";
            }
        }else{
            int remaining = w-lineSum;
            int numDots = remaining/(words.size()-1);
            int leftover = remaining-numDots*(words.size()-1);
            for (int i = 0; i < words.size()-1; i++) {
                String word = words.get(i);
                ret += word;
                for (int j = 0; j < numDots; j++) {
                    ret += ".";
                }
                if (leftover > 0){
                    ret += ".";
                    leftover--;
                }
            }
            ret += words.get(words.size()-1);
        }
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
        for (int i = 0; i < 6; i++) {
            if (lineSum + word.get(i).length() < w){
                lineSum += word.get(i).length();
                lineWords.add(word.get(i));
                if (i == 5){
                    System.out.print(addDot(lineWords,  w, lineSum));
                }
            }else{
                System.out.println(addDot(lineWords, w, lineSum));
                lineSum = 0;
                lineWords.clear();
                lineWords.add(word.get(i));
                lineSum += word.get(i).length();
                if (i == 5){
                    System.out.print(addDot(lineWords, w, lineSum));
                }
            }

        }
    }
}

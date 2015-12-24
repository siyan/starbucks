package com.sywood.starbucks.ben.Waterloo2009;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20094 {
    public static String addDot(ArrayList<String> words, int w, int lineSum){
        String ret = "";
        int spaces = words.size()-1;
        int remain = w-lineSum;
        if (spaces == 0){
            spaces = 1;
        }
        int periods = Math.floorDiv(remain, spaces);
        int tot = 0;
        for (String word: words){
            ret += word;
            tot += word.length();
            for (int i = 0; i < periods; i++) {
                if (!word.equals(words.get(words.size()-1))){
                    System.out.println(i);
                    ret += ".";
                    tot++;
                    if (periods*spaces != remain ){
                        ret += ".";
                        tot ++;
                    }
                }
            }
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
                lineWords = new ArrayList<>();
                lineWords.add(word.get(i));
                lineSum += word.get(i).length();
                if (i == 5){
                    System.out.print(addDot(lineWords, w, lineSum));
                }
            }

        }
    }
}

package com.sywood.starbucks.ben.Waterloo.Waterloo2005;
import java.io.*;

public class Waterloo20055 {
    static String remANA(String word){
        if (word.contains("ANA")){
            return word.replace("ANA", "A");
        }else if(word.contains("BAS")){
            return word.replace("BAS", "A");
        }else{
            return word;
        }
    }

    static boolean monkeyWord(String word) {
        if (word.equals("A")) {
            return true;
        }
        else{
            if (remANA(word).equals(word)){
                return false;
            }else{
                return monkeyWord(remANA(word));
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader("data/banana.in"));
        String word = input.readLine();
        while (!word.equals("X")){
            if (monkeyWord(word)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            word = input.readLine();
        }
    }
}

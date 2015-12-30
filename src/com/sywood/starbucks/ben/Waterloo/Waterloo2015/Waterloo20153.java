package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Scanner;

public class Waterloo20153 {
    private static char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static char[] vowl = "aeiou".toCharArray();

    private static int index(char letter){
        int index = -1;
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] == letter){
                index = i;
            }
        }
        return index;
    }
    private static boolean isVowl(char letter){
        for (char vowel : vowl){
            if (letter == vowel){
                return true;
            }
        }
        return false;
    }
    private static char nextCons(char letter){
        int index = index(letter);
        if (letter != 'z') {
            for (int i = index; i < alph.length - 1; i++) {
                if (!isVowl(alph[i + 1])) {
                    letter = alph[i + 1];
                }
            }
        }
        return letter;
    }
    private static char nextVowl(char letter){
        int index = index(letter);
        int back = 0;
        int front = 0;
        if (letter != 'z') {
            for (int i = index; i < alph.length - 1; i++) {
                if (isVowl(alph[i])){
                    front = i-index;
                }
            }
            for (int i = index; i >= 0; i--) {
                if (isVowl(alph[i])){
                    back = index - i;
                }
            }
        }
        if (front > back){
            return alph[front];
        }else if (back > front){
            return alph[back];
        }else{
            return alph[front];
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        String ret = "";
        for (char letter : word.toCharArray()){
            if (!isVowl(letter)){
                ret += letter;
                ret += nextVowl(letter);
                ret += nextCons(letter);
            }else{
                ret += letter;
            }
        }
        System.out.print(ret);
    }
}

package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Scanner;

public class Waterloo20153 {
    private static char[] cons = "bcdfghjklmnpqrstvwxyz".toCharArray();
    private static char[] vowl = "aaeeeiiiiooooouuuuuuu".toCharArray();
    private static char[] nextC = "cdfghjklmnpqrstvwxyzz".toCharArray();
    private static boolean contains(char[] letters, char letter){
        for (char let : letters){
            if (let == letter){
                return true;
            }
        }
        return false;
    }
    private static int find(char letter){
        for (int i = 0; i < cons.length; i++){
            if (cons[i] == letter){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        String ret = "";
        for (char letter : word.toCharArray()){
            ret += letter;
            if (contains(cons, letter)){
                int index = find(letter);
                ret += vowl[index];
                ret += nextC[index];
            }
        }
        System.out.print(ret);
    }
}

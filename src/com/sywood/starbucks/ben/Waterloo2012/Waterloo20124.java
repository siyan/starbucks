package com.sywood.starbucks.ben.Waterloo2012;
import java.util.Scanner;

public class Waterloo20124 {
    public static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static int find(char word){
        int index = -1;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i]== word){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int K = Integer.parseInt(input.nextLine());
        String reverse = input.nextLine();
        String real = "";

        for (int i = 0; i < reverse.length(); i++) {
            int index = find(reverse.charAt(i))-((i+1)*3 + K);
            while(index < 0) {
                if (index < 0) {
                    index += 26;
                }
            }
            real += alphabet[index];
        }
        System.out.print(real);
    }
}

package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class CCC98S1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numLines = input.nextInt();
        for (int i = 0; i <= numLines; i++){
            String[] words = input.nextLine().split(" ");
            String ret = "";
            for (String word : words){
                if (word.length() == 4){
                    ret += "**** ";
                }else{
                    ret += word + " ";
                }
            }
            System.out.println(ret);
        }
    }
}

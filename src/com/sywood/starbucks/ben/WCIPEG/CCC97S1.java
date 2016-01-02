package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;
import java.util.ArrayList;

public class CCC97S1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int first = Integer.parseInt(input.nextLine());
        for (int i = 0; i < first; i++) {
            ArrayList<String> noun1 = new ArrayList<>();
            int second = Integer.parseInt(input.nextLine());
            int third = Integer.parseInt(input.nextLine());
            int fourth = Integer.parseInt(input.nextLine());
            for (int j = 0; j < second; j++) {
                noun1.add(input.nextLine());
            }
            ArrayList<String> verbs = new ArrayList<>();
            for (int j = 0; j < third; j++) {
                verbs.add(input.nextLine());
            }
            ArrayList<String> nouns = new ArrayList<>();
            for (int j = 0; j < fourth; j++){
                nouns.add(input.nextLine());
            }
            for (String noun : noun1){
                for (String verb : verbs){
                    for (String noun2 : nouns){
                        System.out.println(noun + " " + verb + " " + noun2 + ".");
                    }
                }
            }
        }
    }
}

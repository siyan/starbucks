package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Scanner;

public class Waterloo20152 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int sad = 0;
        int happy = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ':'){
                if (i+2 <= line.length()-1){
                    if (line.charAt(i+1) == '-'){
                        if (line.charAt(i+2) == ')'){
                            happy += 1;
                        }else if (line.charAt(i+2) == '('){
                            sad += 1;
                        }
                    }
                }
            }
        }
        if (happy == 0 & sad == 0){
            System.out.println("none");
        }else if (happy > sad){
            System.out.println("happy");
        }else if (sad > happy){
            System.out.println("sad");
        }else{
            System.out.println("unsure");
        }
    }
}

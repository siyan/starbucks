package com.sywood.starbucks.ben.Dmoj;

import java.util.Scanner;

/**
 * Created by strik on 2016-12-13.
 */
public class harambe {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int numLower = 0, numHigher = 0;
        for(char c : line.toCharArray()){
            if(Character.isUpperCase(c))numHigher++;
            else if(Character.isLowerCase(c))numLower++;
        }
        if(numLower > numHigher)System.out.println(line.toLowerCase());
        else if (numHigher > numLower) System.out.println(line.toUpperCase());
        else System.out.println(line);
    }
}

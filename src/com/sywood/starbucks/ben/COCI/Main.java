//package com.sywood.starbucks.ben.COCI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int counter;
        String[] lines = input.readLine().split(" ");
        int idx = 0;
        for (int i = 0; i < N; i++) {
            counter = 0;
            for(; ;idx++){
                if(Character.isUpperCase(lines[idx].charAt(0)) && isAlpha(lines[idx].substring(0, lines[idx].length()))){
                    counter++;
                }
                if(lines[idx].charAt(lines[idx].length()-1) == '.' || lines[idx].charAt(lines[idx].length()-1) == '?'
                        || lines[idx].charAt(lines[idx].length()-1) == '!' ){
                    if(Character.isUpperCase(lines[idx].charAt(0)) && isAlpha(lines[idx].substring(0, lines[idx].length()-1))){

                        counter++;
                    }
                    break;
                }
            }
            idx++;
            System.out.println(counter);
        }
    }
}

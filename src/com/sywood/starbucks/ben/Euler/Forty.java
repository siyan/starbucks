package com.sywood.starbucks.ben.Euler;

public class Forty {
    public static void main(String[] args){
        String start = "";
        int j = 1;
        while (start.length() <= 1000000) {
            start += Integer.toString(j);
            j++;
        }
        int i = start.charAt(0)-48;
        i *= (start.charAt(9)-48);
        i *= (start.charAt(99)-48);
        i *= (start.charAt(999)-48);
        i *= (start.charAt(9999)-48);
        i *= (start.charAt(99999)-48);
        i *= (start.charAt(999999)-48);
        System.out.println(i);
    }
}

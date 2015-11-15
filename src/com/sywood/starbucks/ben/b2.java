package com.sywood.starbucks.ben;

import java.util.Scanner;


public class b2{
    public static String reverse(String a){
        String ret = "";
        for (int i = a.length(); i >= 0; i--){
            ret += a.charAt(i);
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i >= input.nextInt(); i++){
            int a = Integer.parseInt(reverse(input.next()));
            int b = Integer.parseInt(reverse(input.next()));
            int c = a+b;
            String d = String.valueOf(c);
            d = reverse(d);
            System.out.println(d);
        }
    }
}

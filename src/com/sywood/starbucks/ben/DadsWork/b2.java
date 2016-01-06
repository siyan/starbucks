package com.sywood.starbucks.ben.DadsWork;
import java.util.Scanner;


public class b2{
    public static String reverse(String a){
        StringBuffer buf = new StringBuffer();
        for (int i = a.length()-1; i >= 0; i--){
            buf.append(a.charAt(i));
        }
        return buf.toString();
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = Integer.parseInt(input.nextLine());
        for (int i = 0; i < max; i++){
            String[] ab = input.nextLine().split(" ");
            int c = Integer.parseInt(reverse(ab[0])) + Integer.parseInt(reverse(ab[1]));
            String d = reverse(String.valueOf(c));
            int print = Integer.parseInt(d);
            System.out.println(print);
        }
    }
}

package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Arrays;

public class UVa725 {
    private static String fiveDigits(int num){
        String ret = String.valueOf(num);
        while(ret.length() != 5){
            ret = "0" + ret;
        }
        return ret;
    }
    private static boolean different(int numer, int denom){
        LinkedList<Integer> digits = new LinkedList<>();
        String second = fiveDigits(numer);
        String first = fiveDigits(denom);
        for (int i = 0; i < 5; i++) {
            if (!digits.contains(second.charAt(i) - 48)){
                digits.add(second.charAt(i)-48);
            }else{
                return false;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!digits.contains(first.charAt(i) - 48)){
                digits.add(first.charAt(i)-48);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        while (N != 0){
            boolean found = false;
            for (int numerator = 1; numerator <= 99999; numerator++){
                for(int denominator = 1; denominator <= 99999; denominator++){
                    if (numerator/denominator == N && different(numerator, denominator)){
                        System.out.println(fiveDigits(numerator) + " / " + fiveDigits(denominator) + " = " + N);
                        found = true;
                    }
                }
            }
            if (!found){
                System.out.println("There are no solutions for " + N + ".");
            }
            N = Integer.parseInt(input.readLine());
        }
    }
}

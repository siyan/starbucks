package com.sywood.starbucks.ben.Waterloo2012;
import java.util.Scanner;

public class Waterloo20123 {
    private static String mult(String str, int num){
        String retStr = "";
        for (int i = 0; i < num; i++) {
            retStr += str;
        }

        return retStr;
    }
    private static String row(int row, int k){
        if (row == 1){
            String row1 = "";
            row1 += mult("*", k);
            row1 += mult("X", k);
            row1 += mult("*", k);
            return row1;
        }else if (row == 2){
            String row2 = "";
            row2 += mult(" ", k);
            row2 += mult("X", k);
            row2 += mult("X", k);
            return row2;
        }else if (row == 3){
            String row3 = "";
            row3 += mult("*", k);
            row3 += mult(" ", k);
            row3 += mult("*", k);
            return row3;
        }else{
            return "ERROR";
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < k; j++) {
                System.out.println(row(i+1, k));
            }
        }
    }
}

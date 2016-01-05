package com.sywood.starbucks.ben.Waterloo.Waterloo2014;
import java.util.ArrayList;
import java.util.Scanner;

public class Waterloo20145 {
    private static boolean isIn(ArrayList<String[]> pairs, String num, String num2){
        for (String[] pair:pairs){
            if (num.equals(pair[1]) & !num2.equals(pair[0]) |
                    num.equals(pair[0]) & !num2.equals(pair[1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            a.add(input.next());
        }
        ArrayList<String> b = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            b.add(input.next());
        }
        ArrayList<String[]> pairs = new ArrayList<>();
        boolean good = true;
        for (int i = 0; i < a.size(); i++){
            if (!isIn(pairs, a.get(i), b.get(i))){
                good = false;
            }else{
                pairs.add(new String[]{a.get(i), b.get(i)});
            }
        }
        if (good){
            System.out.print("good");
        }else{
            System.out.print("bad");
        }
    }
}

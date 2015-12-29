package com.sywood.starbucks.ben.Waterloo2014;
import java.util.ArrayList;
import java.util.Scanner;

public class Waterloo20145 {
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

        if (a == b){
            System.out.print("good");
        }
        else{
            boolean equal = true;
            for (int i = 0; i < num ; i++) {
                int other = num - i-1;
                if (!a.get(i).equals(b.get(other))){
                    equal = false;
                }
            }if (equal){
                System.out.print("good");
            }else {
                System.out.print("bad");
            }
        }
    }
}

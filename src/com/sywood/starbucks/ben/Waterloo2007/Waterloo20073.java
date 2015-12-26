package com.sywood.starbucks.ben.Waterloo2007;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20073 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> cases = new ArrayList<>();
        cases.add(100);
        cases.add(500);
        cases.add(1000);
        cases.add(5000);
        cases.add(10000);
        cases.add(25000);
        cases.add(50000);
        cases.add(1000000);
        for (int i = 0; i < Integer.parseInt(input.nextLine()); i++) {
            int index = Integer.parseInt(input.nextLine()) - 1;
            cases.remove(index);
        }
        int average = 0;
        for (int brief: cases){
            average += brief;
        }
        average /= cases.size();
        if (Integer.parseInt(input.nextLine()) > average){
            System.out.print("deal");
        }else{
            System.out.print("no deal");
        }
    }
}

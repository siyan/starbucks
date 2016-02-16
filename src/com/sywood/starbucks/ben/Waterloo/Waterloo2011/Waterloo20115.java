package com.sywood.starbucks.ben.Waterloo.Waterloo2011;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20115 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numPeo = Integer.parseInt(input.nextLine());
        ArrayList<Integer> ways = new ArrayList<>(numPeo);
        for (int i = 0; i < numPeo; i++) {
            ways.add(1);
        }
        for (int i = 1; i < numPeo; i++) {
            int person = input.nextInt()-1;
            ways.set(person, ways.get(person)*(1+ways.get(i)));
        }

        System.out.println(numPeo-1);
    }
}

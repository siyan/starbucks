package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20115 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numPeo = Integer.parseInt(input.nextLine());
        ArrayList<Integer> ways = new ArrayList(numPeo);
        for (int i = 0; i < numPeo; i++) {
            ways.add(1);
        }
        int tot = 0;
        for (int i = 1; i < numPeo; i++) {
            int person = input.nextInt();
            ways.add(person-1, ways.get(person-1)*(1+ways.get(person)));
        }
        for (int num : ways){
            tot += num;
        }
        tot /= 2;
        System.out.print(tot);
    }
}

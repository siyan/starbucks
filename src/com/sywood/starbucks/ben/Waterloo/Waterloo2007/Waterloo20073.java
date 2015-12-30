package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20073 {
    public static int findIndex(int caseNum, ArrayList<Integer> current){
        int index = 0;
        int toFind = 0;
        switch (caseNum){
            case 1: toFind = 100;
                break;
            case 2: toFind = 500;
                break;
            case 3: toFind = 1000;
                break;
            case 4: toFind = 5000;
                break;
            case 5: toFind = 10000;
                break;
            case 6: toFind = 25000;
                break;
            case 7: toFind = 50000;
                break;
            case 8: toFind = 100000;
                break;
            case 9: toFind = 500000;
                break;
            case 10: toFind = 1000000;
                break;
        }

        for (int brief: current){
            if (brief == toFind){
                toFind = index;
            }
            index ++;
        }
        return toFind;
    }

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
        cases.add(100000);
        cases.add(500000);
        cases.add(1000000);
        int iters = Integer.parseInt(input.nextLine());
        for (int i = 0; i < iters; i++) {
            int index = findIndex(Integer.parseInt(input.nextLine()), cases);
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

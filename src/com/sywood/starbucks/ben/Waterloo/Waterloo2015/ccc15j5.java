package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class ccc15j5 {
    private static ArrayList<Integer> shift(ArrayList<Integer> portions){
        for (int i = 0; i < portions.size(); i++){
            if (i != portions.size()-1){
                if (!Objects.equals(portions.get(i), portions.get(i + 1))){
                    portions.set(i, portions.get(i)+1);
                    portions.set(i+1, portions.get(i+1)-1);
                    i = portions.size();
                }
            }
        }
        return portions;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        if (k == n){
            System.out.print(1);
        }
        else{
            ArrayList<ArrayList<Integer>> combos = new ArrayList<>();
            ArrayList<Integer> portion = new ArrayList<>();
            for (int i = 0; i < n; i++){
                int add = i == n-1 ? k - n-1:1;
                portion.add(add);
            }
            combos.add(portion);
            for (int i = 0; i < n; i++){
                portion = shift(portion);
                combos.add(portion);
            }
            System.out.print(combos.size());
        }
    }
}

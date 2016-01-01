package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20154 {
    private static ArrayList<int[]> update(ArrayList<int[]> friends, int[] friend, int newVal){
        boolean found = false;
        for (int[] friend1 : friends) {
            if (friend1[0] == friend[0]) {
                friend1[1] += newVal;
                found = true;
            }
        }
        if (!found){
            friends.add(new int[]{friend[0], friend[1] +newVal});
        }
        return friends;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iters = Integer.parseInt(input.nextLine());
        String first = input.next();
        String previous = "";
        ArrayList<int[]> friends = new ArrayList<>();
        for (int i = 0; i < iters; i++) {

        }
    }
}

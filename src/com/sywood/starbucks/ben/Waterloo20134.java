package com.sywood.starbucks.ben;
import java.util.ArrayList;
import java.util.Scanner;

public class Waterloo20134 {
    public static int mini(ArrayList<Integer> a){
        int small = 0;
        for (Integer anA : a) {
            if (small > anA) {
                small = anA;
            }
        }
        return small;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int chores = 0;
        int iters = input.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>(iters);
        for (int i = 0; i < iters; i++) {
            nums.add(input.nextInt());
        }
        boolean done = false;
        while (!done){
            if (max - mini(nums) >= 0){
                max -= mini(nums);
                nums.remove(mini(nums));
                chores++;
            }
        }
        System.out.print(chores);
    }
}

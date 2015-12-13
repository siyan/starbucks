package com.sywood.starbucks.ben;
import java.util.ArrayList;
import java.util.Scanner;

public class Waterloo20134 {
    public static int mini(ArrayList<Integer> a){
        int small = 999999999;
        int iter = 0;
        for (int i = 0; i < a.size(); i++) {
            if (small > a.get(i)){
                small = a.get(i);
                iter = i;
            }
        }
        return iter;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int chores = 0;
        int iters = input.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < iters; i++) {
            nums.add(input.nextInt());
        }
        boolean done = false;
        while (!done){
            if (max - nums.get(mini(nums)) >= 0){
                max -= nums.get(mini(nums));
                nums.remove(mini(nums));
                chores++;
            }
            if (nums.isEmpty()){
                done = true;
            }
        }
        System.out.print(chores);
    }
}

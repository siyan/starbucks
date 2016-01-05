package com.sywood.starbucks.ben.Waterloo.Waterloo2013;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Waterloo20134 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int chores = 0;
        int iters = input.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Collections.sort(nums);
        for (int i = 0; i < iters; i++) {
            nums.add(input.nextInt());
        }
        for (int num: nums){
            if (max - num >= 0){
                max -= num;
                chores++;
            }
        }
        System.out.print(chores);
    }
}

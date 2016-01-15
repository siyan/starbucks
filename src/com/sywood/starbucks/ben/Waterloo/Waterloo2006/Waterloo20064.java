package com.sywood.starbucks.ben.Waterloo.Waterloo2006;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20064 {
    private static ArrayList<int[]> process(){
        ArrayList<int[]> ret = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int iter = input.nextInt();
        for (int i = 0; i < iter; i++){
            ret.add(new int[]{input.nextInt(), input.nextInt()});
        }
        return ret;
    }
    private static int find(ArrayList<Integer> nums, int num){
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == num){
                return i;
            }
        }
        return -1;
    }
    private static ArrayList<Integer> move(ArrayList<Integer> order, int[] restrict){
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i) == restrict[0]){
                int one = find(order, restrict[0]);
                int other = find(order, restrict[1]);
                int original = order.get(one);
                int second = order.get(other);

            }
        }
        return order;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<int[]> restrictions = process();
        ArrayList<Integer> order = new ArrayList<>();

    }
}

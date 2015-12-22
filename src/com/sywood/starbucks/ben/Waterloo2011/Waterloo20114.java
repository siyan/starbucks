package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Waterloo20114 {
    public static int[] move(String dir, int val){
        if (dir.equals("u")){
            int[] ret = new int[]{0, val};
            return ret;
        }else if (dir.equals("d")){
            int[] ret = new int[]{0, -val};
            return ret;
        }else if (dir.equals("l")){
            int[] ret = new int[]{-val, 0};
            return ret;
        }else{
            int[] ret = new int[]{val, 0};
            return ret;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<int[]> coords = new ArrayList();
        for (int i = -1; i < -201; i++) {
            for (int j = -1; j < -201; j++) {
                int[] a = new int[]{i, j};
                coords.add(a);
            }
        }
        String direction = input.next();
        int value = input.nextInt();
        while (!direction.equals("q")){
            int[] moved = move(direction, value);
            int[] iter = new int[]{coords.get(0)[0]-moved[0], coords.get(0)[1]-moved[1]};
            if (coords.contains(iter)){
                System.out.print(iter[0] + " " + iter[1] + " " + "DANGER");
                direction = "q";
            }else{
                coords.add(iter);
                System.out.println(iter[0] + " " + iter[1] + " " + "safe");
            }
        }
    }
}

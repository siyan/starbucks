package com.sywood.starbucks.ben.Waterloo.Waterloo2010;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20105 {
    private static int[][] stepsTaken = new int[][]{
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999},
            {999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 999999999}};

    private static void hop(int x, int y, int hops){
        if (x < 8 & x >= 0 & y >= 0 & y < 8 & hops < stepsTaken[y][x]){
            stepsTaken[y][x] = hops;
            if (x-1 >= 0 & y-2 >= 0) {
                hop(x - 1, y - 2, hops + 1);
            }if (y+2 < 8){
                hop(x - 1, y + 2, hops + 1);
            }if (x+1 < 8 & y-2 >= 0) {
                hop(x + 1, y - 2, hops + 1);
            }if (y + 2 < 8){
                hop(x + 1, y + 2, hops + 1);
            }if (x-2 >= 0 & y+1 < 8) {
                hop(x - 2, y + 1, hops + 1);
            }if (y-1 >= 0){
                hop(x - 2, y - 1, hops + 1);
            }if (x+2 < 8 & y-1 >= 0) {
                hop(x + 2, y - 1, hops + 1);
            }if (y+1 > 8){
                hop(x + 2, y + 1, hops + 1);
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        hop(x, y, 0);
        int retX = input.nextInt();
        int retY = input.nextInt();
        System.out.println(stepsTaken[retY][retX]);
    }
}

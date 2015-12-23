package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Waterloo20114 {
    public static int[] move(String dir, int val){
        if (dir.equals("u")){
            int[] ret = new int[]{val, 0};
            return ret;
        }else if (dir.equals("d")){
            int[] ret = new int[]{-val, 0};
            return ret;
        }else if (dir.equals("l")){
            int[] ret = new int[]{0, -val};
            return ret;
        }else{
            int[] ret = new int[]{0, val};
            return ret;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<int[]> coords = new ArrayList();
        for (int i = -1; i > -201; i--) {
            for (int j = -200; j < 201; j++){
                coords.add(new int[]{i, j});
            }
        }
        coords.remove(new int[]{-1, 0});
        coords.remove(new int[]{-2, 0});
        coords.remove(new int[]{-3, 0});
        coords.remove(new int[]{-3, 1});
        coords.remove(new int[]{-3, 2});
        coords.remove(new int[]{-3, 3});
        coords.remove(new int[]{-4, 3});
        coords.remove(new int[]{-5, 3});
        coords.remove(new int[]{-5, 4});
        coords.remove(new int[]{-5, 5});
        coords.remove(new int[]{-4, 5});
        coords.remove(new int[]{-3, 5});
        coords.remove(new int[]{-3, 6});
        coords.remove(new int[]{-3, 7});
        coords.remove(new int[]{-4, 7});
        coords.remove(new int[]{-5, 7});
        coords.remove(new int[]{-6, 7});
        coords.remove(new int[]{-7, 7});
        coords.remove(new int[]{-7, 6});
        coords.remove(new int[]{-7, 5});
        coords.remove(new int[]{-7, 4});
        coords.remove(new int[]{-7, 3});
        coords.remove(new int[]{-7, 2});
        coords.remove(new int[]{-7, 1});
        coords.remove(new int[]{-7, 0});
        coords.remove(new int[]{-7, -1});
        coords.remove(new int[]{-6, -1});
        coords.remove(new int[]{-5, -1});

        String direction = input.next();
        int value = input.nextInt();
        while (!direction.equals("q")){
            int[] move = move(direction, value);
            int[] point = new int[]{-5, -1};
            while (value > 0) {
                int row = point[1] + move[1];
                int col = point[0] + move[0];
                if (coords.contains(new int[]{row, col})){
                    System.out.println(col + " " + row + " " + "safe");
                    direction = input.next();
                    value = input.nextInt();
                    coords.remove(coords.indexOf(new int[]{row, col}));
                }else{
                    direction = "q";
                    System.out.println(col + " " + row + " " + "DANGER");
                }
            }
        }
    }
}

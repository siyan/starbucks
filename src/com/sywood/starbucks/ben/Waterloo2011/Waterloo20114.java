package com.sywood.starbucks.ben.Waterloo2011;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Waterloo20114 {
    public static ArrayList<int[]> genArrayList(){
        ArrayList<int[]> ret = new ArrayList<>();
        for (int i = -1; i >-201; i--) {
            for(int j = -200; j < 201; j++){
                ret.add(new int[]{i, j});
                if (i == -1 & j == 0 |
                        i == -2 & j == 0|
                        i == -3 & j == 0|
                        i == -3 & j == 1|
                        i == -3 & j == 2|
                        i == -3 & j == 3|
                        i == -4 & j == 3|
                        i == -5 & j == 4|
                        i == -5 & j == 5|
                        i == -4 & j == 5|
                        i == -3 & j == 5|
                        i == -3 & j == 6|
                        i == -3 & j == 7|
                        i == -4 & j == 7|
                        i == -5 & j == 7|
                        i == -6 & j == 7|
                        i == -7 & j == 7|
                        i == -7 & j == 6|
                        i == -7 & j == 5|
                        i == -7 & j == 4|
                        i == -7 & j == 3|
                        i == -7 & j == 2|
                        i == -7 & j == 1|
                        i == -7 & j == 0|
                        i == -7 & j == -6|
                        i == -6 & j == -1|
                        i == -5 & j == -1){
                    ret.remove(ret.size()-1);
                }
            }
        }
        return ret;
    }

    public static int findIndex(int y, int x){
        int index = 0;
        boolean found = false;
        ArrayList<int[]> block = genArrayList();
        for (int[] coord : block){
            if (!found){
                if (coord[0] == y & coord[1] == x){
                    found = true;
                }else{
                    index++;
                }
            }
        }
        return index;
    }
    public static boolean isIn(int y, int x) {
        boolean found = false;
        ArrayList<int[]> block = genArrayList();
        for (int[] coord : block) {
            if (!found) {
                if (coord[0] == y & coord[1] == x) {
                    found = true;
                }
            }
        }
        return found;
    }

    public static int[] move(String dir, int val){
        if (dir.equals("u")){
            int[] ret = new int[]{0, 1};
            return ret;
        }else if (dir.equals("d")){
            int[] ret = new int[]{0, -1};
            return ret;
        }else if (dir.equals("l")){
            int[] ret = new int[]{1, 0};
            return ret;
        }else{
            int[] ret = new int[]{-1, 0};
            return ret;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<int[]> coords = new ArrayList<>();
        for (int i = -1; i > -201; i--) {
            for (int j = -200; j < 201; j++){
                coords.add(new int[]{i, j});
            }
        }

        String direction = input.next();
        int value = input.nextInt();
        while (!direction.equals("q")){
            int[] move = move(direction, value);
            int[] point = new int[]{-5, -1};
            boolean safe = true;
            int row = 0;
            int col = 0;
            while (value > 0) {
                row = point[1] + move[1];
                col = point[0] + move[0];
                if (isIn(row, col)){
                    value -= 1;
                    coords.remove(findIndex(row, col));
                }else{
                    direction = "q";
                    value = 0;
                    safe = false;
                }
            }
            if (safe){
                System.out.println(col + " " + row + " " + "safe");
            }else{
                System.out.println(col + " " + row + " " + "DANGER");
            }
            direction = input.next();
            value = input.nextInt();
        }
    }
}

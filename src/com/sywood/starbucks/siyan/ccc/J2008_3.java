package com.sywood.starbucks.siyan.ccc;

import java.util.ArrayList;
import java.util.Scanner;


public class J2008_3 {
    public static int[] find(ArrayList<char[]> map, char letter){
        int[] ret = new int[]{-1, -1};
        int row = 0;
        for(char[] roow : map){
            int col = 0;
            for(char let: roow){
                if (let == letter){
                    ret[0] = row;
                    ret[1] = col;
                    return ret;
                }
                col++;
            }
            row++;
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<char[]> map = new ArrayList<>();
        map.add(new char[]{'A', 'B', 'C', 'D', 'E', 'F'});
        map.add(new char[]{'G', 'H', 'I', 'J', 'K', 'L'});
        map.add(new char[]{'M', 'N', 'O', 'P', 'Q', 'R'});
        map.add(new char[]{'S', 'T', 'U', 'V', 'W', 'X'});
        map.add(new char[]{'Y', 'Z', ' ', '-', '.', 'n'});
        String toWrite = "A" + input.nextLine() + "n";
        int dist = 0;
        for (int i = 0; i < toWrite.length() - 1; i++) {
            int[] curr = find(map, toWrite.charAt(i));
            int[] next = find(map, toWrite.charAt(i+1));
            dist += Math.abs(next[0] - curr[0]) + Math.abs(next[1] - curr[1]);
        }
        System.out.println("Output\n" + dist);
    }
}

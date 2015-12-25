package com.sywood.starbucks.ben;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20083 {
    public static int[] find(ArrayList<char[]> map, char letter){
        int[] ret = new int[]{-1, -1};
        int row = 0;
        int col = 0;
        for(char[] roow : map){
            for(char let: roow){
                if (let == letter){
                    ret[0] = row;
                    ret[1] = col;
                }
                col++;
            }
            row++;
        }
        return ret;
    }

    public static void main(char[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<char[]> map = new ArrayList<>();
        map.add(new char[]{'A', 'B', 'C', 'D', 'E', 'F'});
        map.add(new char[]{'G', 'H', 'H', 'I', 'J', 'K'});
        map.add(new char[]{'M', 'N', 'O', 'P', 'Q', 'R'});
        map.add(new char[]{'S', 'T', 'U', 'V', 'W', 'X'});
        map.add(new char[]{'Y', 'Z', ' ', '-', '.', 'n'});
        String toWrite = input.next();
        int dist = 0;
        for (int i = 0; i < toWrite.length(); i++) {
            if (i != toWrite.length()-1){
                int[] curr = find(map, toWrite.charAt(i));
                int[] next = find(map, toWrite.charAt(i+1));
                dist += Math.abs(next[0] - curr[0]) + Math.abs(next[1] - curr[1]);
            }
        }
        System.out.print(dist);
    }
}

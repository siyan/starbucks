package com.sywood.starbucks.ben.HackerRank.WalmarCodesprint;

import java.util.ArrayList;
import java.util.Scanner;

public class Delivery {
    private static boolean canTravel(int start, int end){
        /// one step
        if(end > start){
             if(end == start+start || end == start+start+1 || end == start+1 && Integer.bitCount(end) != 1) return true;
        }else{
            if(Integer.bitCount(start) == 1 && end == start-1) return false;
            else if(end == start-1) return true;
            if(end/2 == start)return true;
        }
        return false;
    }

    public static void main(String[] args)throws Exception{
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //max number of intersections
        int m = input.nextInt();
        int k = input.nextInt();
        int[][] foods = new int[m+1][10];
        boolean[][] avail = new boolean[n+1][11];
        ArrayList<Integer>[] available = new ArrayList[n+1];
        int curr;
        for (int i = 1; i <= m; i++) {
            int total = input.nextInt();
            for (int j = 0; j < total; j++) {
                curr = input.nextInt();
                foods[i][j] = curr;
                avail[curr][j] = true;
            }
        }
        int currPos = 1;
        int timeTaken = 0;


        for (int i = 0; i < k; i++) {

        }
    }
}

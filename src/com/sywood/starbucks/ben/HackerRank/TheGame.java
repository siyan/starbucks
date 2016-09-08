package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * unfinished
 */
public class TheGame {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i < t; i++){
            int n = s.nextInt();
            long[] array = new long[n];
            for(int j = 0; j < n; j++){
                array[j] = s.nextLong();
            }
            long score = 0;
            score = partition(array, 0, n-1, score);
            System.out.println(score);
        }
    }
    public static long partition(long[] array, int start, int end, long score){
        if(start >= end){
            return 0;
        }
        long total = 0; //Total of items in array as the number equal must be half of the total value
        for(int i = start; i <= end; i++){
            total += array[i];
        }
        if(total > 0){
            if(total % 2 != 0){ //The total must be even for any two partitions to be equal
                return 0;
            }
        }
        if(total == 0){
            return array.length-1;
        }
        long totalSoFar = 0; //Track total up to this index
        int newStart = -1;
        for(int i = start; i <= end; i++){
            totalSoFar+=array[i];
            long tempTotal = total-totalSoFar;
            if(tempTotal == total/2){
                newStart = i;
                break;
            }
        }
        if(newStart == -1){
            return 0;
        }
        score = Math.max(partition(array, start, newStart, score), partition(array, newStart+1, end, score))+1;
        return score;
    }
}

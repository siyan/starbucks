package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ben on 2016-08-23.
 */
public class UVa11456 {
    static public ArrayList<Integer> LDS(int[] A) {
        int[] m = new int[A.length];
        //Arrays.fill(m, 1);//not important here
        for (int x = A.length - 2; x >= 0; x--) {
            for (int y = A.length - 1; y > x; y--) {
                if (m[x] < m[y] && A[x] > A[y]) {
                    m[x]=m[y]+1;//or use m[x]++
                }
            }
        }
        int max = m[0];
        for (int i = 0; i < m.length; i++) {
            if (max < m[i]) {
                max = m[i];
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < m.length; i++) {
            if (max == m[i]) {
                result.add(A[i]);
                max--;
            }
        }
        return result;
    }

    private static int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }

    static int longestIncreasingSubSequence(int input[]){
        int T[] = new int[input.length];
        int R[] = new int[input.length];
        for(int i=0; i < R.length ; i++) {
            R[i] = -1;
        }
        T[0] = 0;
        int len = 0;
        for(int i=1; i < input.length; i++){
            if(input[T[0]] > input[i]){ //if input[i] is less than 0th value of T then replace it there.
                T[0] = i;
            }else if(input[T[len]] < input[i]){ //if input[i] is greater than last value of T then append it in T
                len++;
                T[len] = i;
                R[T[len]] = T[len-1];
            }else{ //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(input, T, len, input[i]);
                T[index] = i;
                R[T[index]] = T[index-1];
            }
        }

        //this prints increasing subsequence in reverse order.

        return len+1;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(input.readLine());
            if (n > 0) {
                int nums[] = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = Integer.parseInt(input.readLine());
                }
                System.out.println(((longestIncreasingSubSequence(nums) + LDS(nums).size()-1)));
            }else{
                System.out.println(0);
            }
        }
    }
}

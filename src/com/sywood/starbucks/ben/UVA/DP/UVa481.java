package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa481 {
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
        int index = T[len];
        String ret = "";
        System.out.println(len+1);
        System.out.println("-");
        while(index != -1) {
            ret = Integer.toString(input[index]) + "\n" + ret;
            index = R[index];
        }
        System.out.println(ret.trim());
        return len+1;
    }

    public static void main(String args[])throws Exception{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String line = inp.readLine();
        ArrayList<Integer> in = new ArrayList<>();
        while (line != null && !line.equals("")) {
            in.add(Integer.parseInt(line));
            line = inp.readLine();
        }
        int[] input = new int[in.size()];
        for (int i = 0; i < in.size(); i++) {
            input[i] = in.get(i);
        }
        longestIncreasingSubSequence(input);
    }
}

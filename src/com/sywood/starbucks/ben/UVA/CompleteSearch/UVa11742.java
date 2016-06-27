package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
import java.util.ArrayList;

public class UVa11742 {
    private static int permute(int[] arr, int current, ArrayList<String[]> data){
        int counter = 0;
        for (int i = current; i < arr.length; i++){
            int temp = arr[current];
            arr[current] = arr[i];
            arr[i] = temp;
            permute(arr, current+1, data);
            arr[i] = arr[current];
            arr[current] = temp;
        }
        if (current == arr.length-1){
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.print("]\n");
            counter += test(arr, data) ? 1 : 0;
        }
        return counter;
    }

    private static boolean can(int[] arr, String[] data) {
        int first = Integer.parseInt(data[0]);
        int second = Integer.parseInt(data[1]);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first) {
                first = i;
            } else if (arr[i] == second) {
                second = i;
            }
        }
        return first - second == Integer.parseInt(data[2]);
    }

    private static boolean test(int[] arr, ArrayList<String[]> data) {
        if (data.size() == 0){
            return true;
        }else {
            for (String[] aData : data) {
                if (!can(arr, aData)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] stuff = input.readLine().split(" ");
        int n = Integer.parseInt(stuff[0]);
        int m = Integer.parseInt(stuff[1]);
        while (n != m || m != 0 || n != 0) {
            int[] seats = new int[n];
            for (int i = 0; i < n; i++) {
                seats[i] = i;
            }
            ArrayList<String[]> restrictions = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                restrictions.add(input.readLine().split(" "));
            }
            System.out.println(permute(seats, 0, restrictions));
            stuff = input.readLine().split(" ");
            n = Integer.parseInt(stuff[0]);
            m = Integer.parseInt(stuff[1]);
        }
    }
}
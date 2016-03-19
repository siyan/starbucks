package com.sywood.starbucks.ben.Recursion;
import java.util.Scanner;
public class Sticks {
    static int[] pos;
    static int min = 999999999;
    static int split(int size){
        if (size == 0){
            return 0;
        }else{
            for (int i = 0; i < pos.length; i++){
                int current = size;
                int one = current-pos[i];
                int two = pos[i];
                if (i <= pos.length-1 && one < pos[i+1] && two < pos[i+1]){
                    return 0;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = Integer.parseInt(input.nextLine());
        while (length != 0) {
            int iter = Integer.parseInt(input.nextLine());
            pos = new int[iter];
            for (int i = 0; i < iter; i++) {
                pos[i] = input.nextInt();
            }
            System.out.println("The minimum cutting is " + split(length));
            length = Integer.parseInt(input.nextLine());
        }
    }
}
